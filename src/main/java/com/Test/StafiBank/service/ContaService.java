package com.Test.StafiBank.service;

import java.math.BigDecimal;
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
import com.Test.StafiBank.service.exeptions.InsufficientBalanceException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = contaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found));
    }

    public Conta insert(Conta objConta) {
        return contaRepository.save(objConta);
    }

    public Conta update(Long id, BigDecimal deposito) {
        try {
            Conta entityUpdate = contaRepository.getReferenceById(id);
            entityUpdate.setCarteira(entityUpdate.getCarteira());
            return contaRepository.save(entityUpdate);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Validation_error);
        }
    }

    public Conta depositar(Long id, BigDecimal deposito) {
        try {
            Conta entityUpdate = contaRepository.getReferenceById(id);
            entityUpdate.setCarteira(entityUpdate.getCarteira().add(deposito));
            return contaRepository.save(entityUpdate);
        } catch (InsufficientBalanceException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Validation_error);
        }
    }

    public Conta sacar(Long id, BigDecimal saque) {
        try {
            Conta entityUpdate = contaRepository.getReferenceById(id);
            entityUpdate.setCarteira(entityUpdate.getCarteira().subtract(saque));
            return contaRepository.save(entityUpdate);
        } catch (InsufficientBalanceException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Validation_error);
        }
    }

    public void delete(Long id) {
        try {
            contaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id, ExceptionEnum.Resource_not_found);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage(), ExceptionEnum.Database_error);
        }
    }
}
