package com.Test.StafiBank.dto.usuarioDto;

import com.Test.StafiBank.entities.enun.tipoEnum;

public class UsuarioPost {
    
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private Integer tipo;
    private String cpfCnpj;

    public UsuarioPost(){}

    public UsuarioPost(Long id,String nome,String email,tipoEnum tipo,String senha,String cpString){
        super();
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        setTipoEnum(tipo);
        this.senha = senha;
        this.cpfCnpj = cpString;
    }

    public Long getId() {
        return idUsuario;
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
        return tipoEnum.valueOf(tipo.intValue());
    }
    public void setId(Long id) {
        this.idUsuario = id;
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
    public void setTipoEnum(tipoEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.getCode();
        }
    }
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public Integer getTipo() {
        return tipo;
    }
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
