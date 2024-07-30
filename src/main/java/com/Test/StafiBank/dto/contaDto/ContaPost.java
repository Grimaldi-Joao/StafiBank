package com.Test.StafiBank.dto.contaDto;

import com.Test.StafiBank.entities.Conta;

public class ContaPost {
    
    private Long idConta;
    private String nomeUsuario;
    private Long idUsuario;

    // Construtores
    public ContaPost() {
    }

    public ContaPost(Conta Obj) {
        this.idConta = Obj.getId_Conta();
        this.nomeUsuario = Obj.getUsuarioNome().getNome();
        this.idUsuario = Obj.getFk_Usuario_Id().getId();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
