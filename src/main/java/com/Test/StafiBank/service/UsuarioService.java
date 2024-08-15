package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.Test.StafiBank.dto.usuarioDto.UsuarioPut;
import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.entities.enun.tipoEnum;
import com.Test.StafiBank.repository.UsuarioRepository;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.EmailException;
import com.Test.StafiBank.service.exeptions.IllegalArgument;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$";

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
    Optional<Usuario> obj = repository.findById(id);
    return obj.orElseThrow(()-> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
    }

    public Usuario insert(Usuario usuario) {
        checkEmail(usuario);
        checkCPF(usuario);
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

    private void checkEmail(Usuario user){
		if(repository.existsByEmail(user.getEmail()) != false){
			throw new EmailException("Email is being used", ExceptionEnum.New_user_error);
		}
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			throw new EmailException("Invalid Email", ExceptionEnum.Validation_error);
		}
	}

    private void checkCPF(Usuario user){
        if (repository.existsBycpfCnpj(user.getCpfCnpj()) && user.gettipoEnum() == tipoEnum.Usuario) {
            throw new IllegalArgument("CPF já está sendo utilizado", ExceptionEnum.CPF_ja_Utilizado);
        }
    }

    private void updateData(Usuario entity, UsuarioPut dto) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
    }

}
