package com.Test.StafiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.xml.bind.ValidationException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow();
    }

        public Usuario insert(Usuario objUsuario) {;
		return repository.save(objUsuario);
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

    public Usuario update(Long id, Usuario objUsuario) {
		try {
			Usuario entityUpdate = repository.getReferenceById(id);
			return repository.save(entityUpdate);
		} catch (EntityNotFoundException e) {
			throw new ;
		}	
	}

}
