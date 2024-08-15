package com.Test.StafiBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.StafiBank.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Usuario findByEmail(String email);

    public boolean existsByEmail(String email);

    public boolean existsBycpfCnpj(String cpfCnpj);

}
