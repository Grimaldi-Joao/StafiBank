package com.Test.StafiBank.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Test.StafiBank.dto.emailDto.EmailDto;
import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.entities.enun.tipoEnum;
import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;
import com.Test.StafiBank.repository.TransferenciaRepository;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.InsufficientBalanceException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;
import com.Test.StafiBank.service.exeptions.illegaltransitionargument;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private emailService emailService;

    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }

    // Buscar transferência por ID
    public Transferencia findById(Long id) {
        Optional<Transferencia> obj = transferenciaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
    }

    public void delete(Long id) {
        try {
            extorno(id);
            transferenciaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage(), ExceptionEnum.Database_error);
        }
    }

    public void extorno(Long id) {
        Transferencia transferencia = transferenciaRepository.getReferenceById(id);
        contaService.depositar(transferencia.getRemetente().getidConta(), transferencia.getValor_Transferencia());
        contaService.sacar(transferencia.getDestinatario().getidConta(), transferencia.getValor_Transferencia());
    }
    // @Transient

    public void realizarTransferencia(Transferencia transferenciaPost) {

        transferenciaPost.setTipoTransferenciaEnum(encontrarTipo(transferenciaPost));
        // Verificar saldo da conta remetente
        validacaoDaCarteira(transferenciaPost);

        // Atualizar saldos
        transferenciaPost.getRemetente().setCarteira(
                transferenciaPost.getRemetente().getCarteira().subtract(transferenciaPost.getValor_Transferencia()));
        transferenciaPost.getDestinatario().setCarteira(
                transferenciaPost.getDestinatario().getCarteira().add(transferenciaPost.getValor_Transferencia()));

        contaService.update(transferenciaPost.getRemetente().getidConta(),
                transferenciaPost.getRemetente().getCarteira());
        contaService.update(transferenciaPost.getDestinatario().getidConta(),
                transferenciaPost.getDestinatario().getCarteira());

        // Criar transferência
        Transferencia transferencia = new Transferencia(transferenciaPost.getTipoTransferenciaEnum(),
                transferenciaPost.getValor_Transferencia(), transferenciaPost.getRemetente(),
                transferenciaPost.getDestinatario(), LocalDateTime.now());

        transferencia = transferenciaRepository.save(transferencia);

        enviarEmailTransferencia(transferencia, transferencia.getDestinatario());
    }

    private tipoTransferenciaEnum encontrarTipo(Transferencia transferencia) {
        if (transferencia.getRemetente().getfkUsuarioId().gettipoEnum() == tipoEnum.Loja) {
            throw new illegaltransitionargument("Stores cannot make transfers", ExceptionEnum.Database_error);
        } else if (transferencia.getRemetente().getfkUsuarioId().gettipoEnum() == transferencia.getDestinatario()
                .getfkUsuarioId().gettipoEnum()) {
            return tipoTransferenciaEnum.Usuario_Usuario;
        }
        return tipoTransferenciaEnum.Usuario_Loja;
    }

    private void validacaoDaCarteira(Transferencia transferenciaPost) {
        if (transferenciaPost.getRemetente().getCarteira().compareTo(transferenciaPost.getValor_Transferencia()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance in the sender account.",
                    ExceptionEnum.Validation_error);
        }
    }

    @Transactional
    public void enviarEmailTransferencia(Transferencia transferencia, Conta contaDestino) {
        String destinatario = contaDestino.getfkUsuarioId().getEmail();
        String assunto = "Transferência Recebida";
        String corpo = "Você recebeu uma transferência no valor de " + transferencia.getValor_Transferencia()
                + " reais.";
        EmailDto emailDto = new EmailDto(destinatario, assunto, corpo);
        emailService.enviarEmail(emailDto);
    }

}
