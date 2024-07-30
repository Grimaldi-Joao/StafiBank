package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.repository.ContaRepository;

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
        return obj.orElseThrow();
    }

        public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ;
		} catch (DataIntegrityViolationException e) {
			throw new ;
		}
	}
        /*
         * catch(RunTimeExepition e){
         * e.printStackTrace();
         * }
         * use esse codigo para imprimir o erro no terminal e descobri como trata-lo
         */

    public Conta update(Long id, Conta objConta) {
		try {
			Conta entityUpdate = repository.getReferenceById(id);
			return repository.save(entityUpdate);
		} catch (EntityNotFoundException e) {
			throw new ;
		}	
	}
}
