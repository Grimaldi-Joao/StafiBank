package com.Test.StafiBank.dto.usuarioDto;

public class UsuarioGet {

    private Long id_Usuario;
    private String nome;
    private String email;
    private String tipo;

    public UsuarioGet(){}

    public UsuarioGet(Long id, String nome, String email, String tipo){
        this.id_Usuario = id;
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }
    public Long getId_Usuario() {
        return id_Usuario;
    }public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
