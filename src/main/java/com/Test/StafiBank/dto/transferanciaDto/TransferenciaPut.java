package com.Test.StafiBank.dto.transferanciaDto;

import java.math.BigDecimal;

public class TransferenciaPut {
    
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private String remetente;
    private String destinatario;

    public TransferenciaPut(){}

    public TransferenciaPut(Long id, String tipo, BigDecimal valor, String remetente, String destinatario){
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }
    public Long getId() {
        return id;
    }
    public String getRemetente() {
        return remetente;
    }
    public String getTipo() {
        return tipo;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
