package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.Test.StafiBank.dto.usuarioDto.UsuarioPut;
import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.repository.UsuarioRepository;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
    Optional<Usuario> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
    }

    public Usuario insert(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Long id, UsuarioPut dto) {
        try {
            Usuario entityUpdate = repository.getReferenceById(id);
            updateData(entityUpdate, dto);
            return repository.save(entityUpdate);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Validation_error);
        }
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

    private void updateData(Usuario entity, UsuarioPut dto) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
    }

}
