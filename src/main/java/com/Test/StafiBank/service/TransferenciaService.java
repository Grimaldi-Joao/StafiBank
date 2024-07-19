package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Transferencia;

@Service
public class TransferenciaRepository {
    
    @Autowired
    private TransferenciaRepository repository;

    public List<Transferencia> findAll(){
        return repository.findAll();
    }

    public Transferencia findById(Long id){
        Optional<Transferencia> obj = repository.findById(id);
        return obj.orElseThrow();
    }
}
