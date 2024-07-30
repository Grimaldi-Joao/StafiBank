package com.Test.StafiBank.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.StafiBank.dto.contaDto.ContaGet;
import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.service.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<List<ContaGet>> findAll() {
        List<Conta> list = service.findAll();
        List<ContaGet> listDtoUsers = list.stream().map(ContaGet::new).collect(Collectors.toList());
        
        return ResponseEntity.ok().body(listDtoUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaGet> findById(@PathVariable Long id) {
        Conta objConta = service.findById(id);
        ContaGet objUserDtoGet = new ContaGet(objConta);
        return ResponseEntity.ok().body(objUserDtoGet);
    }

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    
    
}