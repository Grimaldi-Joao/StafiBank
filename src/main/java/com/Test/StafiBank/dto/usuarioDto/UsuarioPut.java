package com.Test.StafiBank.dto.usuarioDto;

public class UsuarioPut {
    private Long idUsuario;
    private String nome;
    private String email;
    private String tipo;

    public UsuarioPut(){}

    public UsuarioPut(String nome, String email, String tipo){
        this.email = email;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }
    public Long getidUsuario() {
        return idUsuario;
    }public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setidUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
