package com.Test.StafiBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.StafiBank.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
}
