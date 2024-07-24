package com.Test.StafiBank.dto.contaDto;

import com.Test.StafiBank.entities.Conta;

public record ContaGet(Long id_Conta, String nome) {

    public ContaGet converter(Conta objConta){
        this.id_Conta = objConta.getId_Conta();
        this.nome = objConta.nome;
    }
}
