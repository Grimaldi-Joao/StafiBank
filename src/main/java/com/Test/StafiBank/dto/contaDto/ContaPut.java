package com.Test.StafiBank.dto.contaDto;

import java.math.BigDecimal;

import com.Test.StafiBank.entities.Conta;

public class ContaPut {
    
    private BigDecimal Carteira;

    public ContaPut(){}

    public ContaPut(Conta carteira){
        this.Carteira = carteira.getCarteira();
    }

    public BigDecimal getCarteira() {
        return Carteira;
    }

    public void setCarteira(BigDecimal carteira) {
        Carteira = carteira;
    }
}
