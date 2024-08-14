package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.repository.ContaRepository;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository repository;

    public List<Conta> findAll(){
        return repository.findAll();
    }

    public Conta findById(Long id){
        Optional<Conta> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
    }

    public Conta insert(Conta objConta) {
        return repository.save(objConta);
    }

    public Conta update(Long id, Conta dto) {
        try {
            Conta entityUpdate = repository.getReferenceById(id);
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
}
