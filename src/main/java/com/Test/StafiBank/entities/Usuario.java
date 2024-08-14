package com.Test.StafiBank.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.Test.StafiBank.entities.enun.tipoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuario;
    private String nome;
    private String email;
    private String cpfCnpj;
    private Integer tipo;
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_Usuario_Id") // Referenciando o campo 'fk_Usuario_Id' em 'Conta'
    private Set<Conta> contas = new HashSet<>();

    public Usuario(){}

    public Usuario(Long idUsuario, String nome, String email, tipoEnum tipo, String cpfCnpj, String senha) {
        super();
        this.nome = nome;
        this.email = email;
        settipoEnum(tipo);
        this.cpfCnpj = cpfCnpj;
        this.senha = senha;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public Set<Conta> getContas() {
        return contas;
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
    public tipoEnum gettipoEnum() {
        return tipoEnum.valueOf(tipo);
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
    public void settipoEnum(tipoEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.getCode();
        }
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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
