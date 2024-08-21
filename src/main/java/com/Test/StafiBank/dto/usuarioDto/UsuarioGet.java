package com.Test.StafiBank.dto.usuarioDto;

import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.entities.enun.tipoEnum;

public class UsuarioGet {

    private Long idUsuario;
    private String nome;
    private String email;
    private Integer tipo;

    public UsuarioGet(){}

    public UsuarioGet(Long id, String nome, String email, tipoEnum tipo){
        this.idUsuario = id;
        this.email = email;
        this.nome = nome;
        setTipoEnum(tipo);
    }

    public UsuarioGet(Usuario Obj) {
        this.idUsuario = Obj.getId();
        this.nome = Obj.getNome();
        this.email = Obj.getEmail();
        setTipoEnum(Obj.gettipoEnum());
        
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
