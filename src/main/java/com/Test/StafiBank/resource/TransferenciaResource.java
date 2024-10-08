package com.Test.StafiBank.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import com.Test.StafiBank.dto.transferanciaDto.TransferenciaGet;
import com.Test.StafiBank.dto.transferanciaDto.TransferenciaPost;
import com.Test.StafiBank.dto.transferanciaDto.response.TransferenciaResponseDTO;
import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.service.ContaService;
import com.Test.StafiBank.service.TransferenciaService;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaResource {

    @Autowired
    private TransferenciaService TransferenciaService;

    @Autowired
    private ContaService ContaService;

    @GetMapping
    public ResponseEntity<List<TransferenciaGet>> findAll() {
        List<Transferencia> list = TransferenciaService.findAll();
        List<TransferenciaGet> listDtoTransgerencias = list.stream().map(TransferenciaGet::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDtoTransgerencias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferenciaGet> findById(@PathVariable Long id) {
        Transferencia obj = TransferenciaService.findById(id);
        TransferenciaGet objTransferenciaGet = new TransferenciaGet(obj);
        return ResponseEntity.ok().body(objTransferenciaGet);
    }

    @PostMapping
    public ResponseEntity<TransferenciaResponseDTO> realizarTransferencia(
            @RequestBody TransferenciaPost transferenciaPost) {
        Conta remetente = ContaService.findById(transferenciaPost.getRemetente());
        Conta destinaraio = ContaService.findById(transferenciaPost.getDestinatario());
        Transferencia objTransferencia = new Transferencia(null, transferenciaPost.getValor(), remetente, destinaraio,
                LocalDateTime.now());
        TransferenciaService.realizarTransferencia(objTransferencia);
        TransferenciaResponseDTO transferencia = new TransferenciaResponseDTO(objTransferencia.getId_Transferencia(),
                objTransferencia.getTipoTransferenciaEnum(), objTransferencia.getRemetente().getfkUsuarioId().getNome(),
                objTransferencia.getDestinatario().getfkUsuarioId().getNome(), objTransferencia.getMomento());
        return ResponseEntity.ok().body(transferencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        TransferenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}