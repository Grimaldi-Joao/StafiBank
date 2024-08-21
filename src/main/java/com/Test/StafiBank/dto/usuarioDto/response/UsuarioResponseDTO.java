package com.Test.StafiBank.dto.usuarioDto.response;

import com.Test.StafiBank.entities.enun.tipoEnum;

public class UsuarioResponseDTO {
    
    private Long idUsuario;
    private String nome;
    private String email;
    private Integer tipo;

    public UsuarioResponseDTO(){}

    public UsuarioResponseDTO(Long id, String nome, String email, tipoEnum tipo){
        this.idUsuario = id;
        this.email = email;
        this.nome = nome;
        setTipoEnum(tipo);
    }

    public String getEmail() {
        return email;
    }
    public Long getidUsuario() {
        return idUsuario;
    }public String getNome() {
        return nome;
    }
    public tipoEnum gettipoEnum() {
        return tipoEnum.valueOf(tipo);
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
    public void setTipoEnum(tipoEnum tipoEnum) {
        if (tipoEnum != null) {
            this.tipo = tipoEnum.getCode();
        }
    }
}
