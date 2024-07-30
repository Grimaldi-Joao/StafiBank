package com.Test.StafiBank.dto.contaDto.response;

import com.Test.StafiBank.entities.Conta;

public class ContaResponseDTO {
    
    private Long idConta;
    private String nomeUsuario;
    private Long idContaUsuario;

    // Construtores
    public ContaResponseDTO() {
    }

    public ContaResponseDTO(Conta Obj) {
        this.idConta = Obj.getId_Conta();
        this.nomeUsuario = Obj.getUsuarioNome().getNome();
        this.idContaUsuario = Obj.getFk_Usuario_Id().getId();
    }

    public Long getIdContaUsuario() {
        return idContaUsuario;
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
    public void setIdContaUsuario(Long idContaUsuario) {
        this.idContaUsuario = idContaUsuario;
    }
}
