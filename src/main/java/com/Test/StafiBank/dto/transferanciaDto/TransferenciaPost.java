package com.Test.StafiBank.dto.transferanciaDto;

import java.math.BigDecimal;

public class TransferenciaPost {
    
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private Long remetente;
    private Long destinatario;

    public TransferenciaPost(){}

    public TransferenciaPost(Long id, String tipo, BigDecimal valor, Long remetente, Long destinatario){
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public Long getDestinatario() {
        return destinatario;
    }
    public Long getId() {
        return id;
    }
    public Long getRemetente() {
        return remetente;
    }
    public String getTipo() {
        return tipo;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setDestinatario(Long destinatario) {
        this.destinatario = destinatario;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setRemetente(Long remetente) {
        this.remetente = remetente;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
