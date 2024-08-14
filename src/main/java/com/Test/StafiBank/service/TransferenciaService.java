package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;
import com.Test.StafiBank.repository.TransferenciaRepository;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.InsufficientBalanceException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private ContaService contaRepository;

    public List<Transferencia> findAll() {
    return repository.findAll();
}

  // Buscar transferência por ID
public Transferencia findById(Long id) {
    Optional<Transferencia> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
}

    public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage(), ExceptionEnum.Database_error);
		}
	}

        public void realizarTransferencia(Transferencia transferenciaPost) {
            Conta remetente = contaRepository.findById(transferenciaPost.getRemetente().getId_Conta());
            Conta destinatario = contaRepository.findById(transferenciaPost.getDestinatario().getId_Conta());
    
             // Verificar saldo da conta remetente
            if (remetente.getCarteira().compareTo(transferenciaPost.getValor_Transferencia()) < 0) {
                throw new InsufficientBalanceException("Saldo insuficiente na conta remetente.", ExceptionEnum.Validation_error);
            }
    
             // Atualizar saldos
            remetente.setCarteira(remetente.getCarteira().subtract(transferenciaPost.getValor_Transferencia()));
            destinatario.setCarteira(destinatario.getCarteira().add(transferenciaPost.getValor_Transferencia()));
    
            contaRepository.update(remetente.getId_Conta(), remetente);
            contaRepository.update(destinatario.getId_Conta(), destinatario);
    
             // Criar transferência
            Transferencia transferencia = new Transferencia(null, tipoTransferenciaEnum.valueOf(0), 
                transferenciaPost.getValor_Transferencia(), remetente, destinatario);
            transferencia = repository.save(transferencia);
    
        }
    
}
