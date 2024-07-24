package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.repository.TransferenciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository repository;

    public List<Transferencia> findAll(){
        return repository.findAll();
    }

    public Transferencia findById(Long id){
        Optional<Transferencia> obj = repository.findById(id);
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

    public Transferencia update(Long id, Transferencia objTransferencia) {
		try {
			Transferencia entityUpdate = repository.getReferenceById(id);
			return repository.save(entityUpdate);
		} catch (EntityNotFoundException e) {
			throw new ;
		}	
	}
}
