package com.Test.StafiBank.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.service.TransferenciaService;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaResource {

    @Autowired
    private TransferenciaService service;

    @GetMapping
    public ResponseEntity<List<TransferenciaGet>> findAll() {
        List<Transferencia> list = service.findAll();
        List<TransferenciaGet> listDtoTransgerencias = list.stream().map(TransferenciaGet::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDtoTransgerencias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferenciaGet> findById(@PathVariable Long id) {
        Transferencia obj = service.findById(id);
        TransferenciaGet objTransferenciaGet = new TransferenciaGet(obj);
        return ResponseEntity.ok().body(objTransferenciaGet);
    }

    @PostMapping
    public ResponseEntity<TransferenciaResponseDTO> realizarTransferencia(@RequestBody TransferenciaPost transferenciaPost) {
        Transferencia objTransferencia = service.findById(transferenciaPost.getId());
        service.realizarTransferencia(objTransferencia);
        TransferenciaResponseDTO transferencia = new TransferenciaResponseDTO(objTransferencia.getId_Transferencia(),objTransferencia.gettipoTransferenciaEnum(),objTransferencia.getRemetente().getFk_Usuario_Id().getNome(),objTransferencia.getDestinatario().getFk_Usuario_Id().getNome());
        return ResponseEntity.ok().body(transferencia);
    }

}