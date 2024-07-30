package com.Test.StafiBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.StafiBank.entities.Transferencia;


public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
    
}