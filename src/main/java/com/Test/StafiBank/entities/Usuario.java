package com.Test.StafiBank.entities;

import java.io.Serializable;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuario;
    private String nome;
    private String email;
    private String tipo;
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Conta> contas;

    public Usuario(){}

    public Usuario(Long id,String nome,String email,String tipo,String senha){
        super();
        this.id_Usuario = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.senha = senha;
    }

    public Long getId() {
        return id_Usuario;
    }
    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public String getTipo() {
        return tipo;
    }
    public void setId(Long id) {
        this.id_Usuario = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+((id_Usuario == null) ? 0 : id_Usuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id_Usuario == null) {
            if(other.id_Usuario != null)
                return false;
        }else if(!id_Usuario.equals(other.id_Usuario)){
            return false;
        }
        return true;
    }

}
