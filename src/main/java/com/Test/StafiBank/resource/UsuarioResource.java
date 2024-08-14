package com.Test.StafiBank.resource;

import java.util.List;
import java.util.stream.Collectors;

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


import com.Test.StafiBank.dto.usuarioDto.UsuarioGet;
import com.Test.StafiBank.dto.usuarioDto.UsuarioPost;
import com.Test.StafiBank.dto.usuarioDto.UsuarioPut;
import com.Test.StafiBank.dto.usuarioDto.response.UsuarioResponseDTO;
import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioGet>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        List<UsuarioGet> listDtoUsuario = list.stream().map(UsuarioGet::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDtoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGet> findById(@PathVariable Long id) {
        Usuario obj = usuarioService.findById(id);
        UsuarioGet objUsuarioGet = new UsuarioGet(obj);
        return ResponseEntity.ok().body(objUsuarioGet);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> insert(@RequestBody UsuarioPost dto) {
        Usuario newObj = new Usuario(dto.getId(), dto.getNome(), dto.getEmail(), dto.gettipoEnum(), dto.getCpfCnpj(), dto.getSenha());
        usuarioService.insert(newObj);
        UsuarioResponseDTO responseDto = new UsuarioResponseDTO(newObj.getId(), newObj.getNome(), newObj.getEmail(), newObj.gettipoEnum());
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody UsuarioPut dto) {
        Usuario newObj = usuarioService.update(id, dto);
        UsuarioResponseDTO responseDto = new UsuarioResponseDTO(newObj.getId(), newObj.getNome(), newObj.getEmail(), null);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}