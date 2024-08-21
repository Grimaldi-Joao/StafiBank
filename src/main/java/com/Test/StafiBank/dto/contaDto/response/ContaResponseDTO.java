package com.Test.StafiBank.dto.contaDto.response;

import com.Test.StafiBank.entities.Conta;
import java.math.BigDecimal;

public class ContaResponseDTO {
    
    private Long idConta;
    private String nomeUsuario;
    private Long idContaUsuario;
    private BigDecimal Carteira;

    public ContaResponseDTO() {
    }

    public ContaResponseDTO(Conta Obj) {
        this.idConta = Obj.getidConta();
        this.nomeUsuario = Obj.getfkUsuarioId().getNome();
        this.idContaUsuario = Obj.getfkUsuarioId().getId();
        this.Carteira = Obj.getCarteira();
    }

    public BigDecimal getCarteira() { 
        return Carteira; 
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
    
    public void setCarteira(BigDecimal carteira) {
        Carteira = carteira;
    }
}
