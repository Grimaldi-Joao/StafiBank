package com.Test.StafiBank.dto.usuarioDto;

public class UsuarioPost {
    
    private Long id_Usuario;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public UsuarioPost(){}

    public UsuarioPost(Long id,String nome,String email,String tipo,String senha){
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

}
