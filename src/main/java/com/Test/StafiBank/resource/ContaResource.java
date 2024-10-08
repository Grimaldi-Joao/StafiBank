package com.Test.StafiBank.resource;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Test.StafiBank.dto.contaDto.ContaGet;
import com.Test.StafiBank.dto.contaDto.ContaPost;
import com.Test.StafiBank.dto.contaDto.ContaPut;
import com.Test.StafiBank.dto.contaDto.response.ContaResponseDTO;
import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.service.ContaService;
import com.Test.StafiBank.service.UsuarioService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ContaGet>> findAll() {
        List<Conta> list = contaService.findAll();
        List<ContaGet> listDtoUsers = list.stream().map(ContaGet::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDtoUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaGet> findById(@PathVariable Long id) {
        Conta objConta = contaService.findById(id);
        ContaGet objUserDtoGet = new ContaGet(objConta);
        return ResponseEntity.ok().body(objUserDtoGet);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContaResponseDTO> insert(@Valid @RequestBody ContaPost objUserDTOPost) {
        Usuario UsuarioConta = usuarioService.findById(objUserDTOPost.getIdUsuario());
        Conta newUser = new Conta(null, UsuarioConta);
        newUser = contaService.insert(newUser);
        ContaResponseDTO responseNewUser = new ContaResponseDTO(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getidConta()).toUri();
        return ResponseEntity.created(uri).body(responseNewUser);
    }

    @PutMapping(value = "/{id}/deposito")
    public ResponseEntity<ContaResponseDTO> deposito(@PathVariable Long id, @Valid @RequestBody ContaPut objUser) {

        Conta newUserPut = contaService.findById(id);
        newUserPut = contaService.depositar(id, objUser.getCarteira());
        ContaResponseDTO ContaresponseNewUserUpdate = new ContaResponseDTO(newUserPut);
        return ResponseEntity.ok().body(ContaresponseNewUserUpdate);
    }

    @PutMapping(value = "/{id}/saque")
    public ResponseEntity<ContaResponseDTO> saque(@PathVariable Long id, @Valid @RequestBody ContaPut objUser) {
        Conta newUserPut = contaService.findById(id);
        newUserPut = contaService.sacar(id, objUser.getCarteira());
        ContaResponseDTO ContaresponseNewUserUpdate = new ContaResponseDTO(newUserPut);
        return ResponseEntity.ok().body(ContaresponseNewUserUpdate);
    }

}