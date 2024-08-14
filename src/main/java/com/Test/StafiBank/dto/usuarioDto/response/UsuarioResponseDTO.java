package com.Test.StafiBank.dto.usuarioDto.response;

import com.Test.StafiBank.entities.enun.tipoEnum;

public class UsuarioResponseDTO {
    
    private Long id_Usuario;
    private String nome;
    private String email;
    private Integer tipo;

    public UsuarioResponseDTO(){}

    public UsuarioResponseDTO(Long id, String nome, String email, tipoEnum tipo){
        this.id_Usuario = id;
        this.email = email;
        this.nome = nome;
        settipoEnum(tipo);
    }

    public String getEmail() {
        return email;
    }
    public Long getId_Usuario() {
        return id_Usuario;
    }public String getNome() {
        return nome;
    }
    public tipoEnum gettipoEnum() {
        return tipoEnum.valueOf(tipo);
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
    public void settipoEnum(tipoEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.getCode();
        }
    }
}
