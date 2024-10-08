package com.Test.StafiBank.dto.contaDto;

import com.Test.StafiBank.entities.Conta;

public class ContaGet {

    private Long idConta;
    private String nomeUsuario;

    // Construtores
    public ContaGet() {
    }

    public ContaGet(Conta Obj) {
        this.idConta = Obj.getidConta();
        this.nomeUsuario = Obj.getfkUsuarioId().getNome();
    }

    // Getters and setters
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
}
