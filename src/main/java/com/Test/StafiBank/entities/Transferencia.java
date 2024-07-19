package com.Test.StafiBank.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tranferencia")
public class Transferencia implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Transferencia;
    private String tipo_Transferencia;//Mudar para enum
    private BigDecimal valor_Transferencia;
    
    @ManyToOne
    @JoinColumn(name = "remetente")
    private Conta remetente;
    
    @ManyToOne
    @JoinColumn(name = "destinatario")
    private Conta destinatario;

    public Transferencia(){}

    public Transferencia(Long id, String tipo, BigDecimal valor, Conta remetente, Conta destinatario){
        this.id_Transferencia = id;
        this.tipo_Transferencia = tipo;
        this.valor_Transferencia = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public Conta getDestinatario() {
        return destinatario;
    }
    public Long getId_Transferencia() {
        return id_Transferencia;
    }
    public Conta getRemetente() {
        return remetente;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getTipo_Transferencia() {
        return tipo_Transferencia;
    }
    public BigDecimal getValor_Transferencia() {
        return valor_Transferencia;
    }


    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }
    public void setId_Transferencia(Long id_Transferencia) {
        this.id_Transferencia = id_Transferencia;
    }
    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }
    public void setTipo_Transferencia(String tipo_Transferencia) {
        this.tipo_Transferencia = tipo_Transferencia;
    }
    public void setValor_Transferencia(BigDecimal valor_Transferencia) {
        this.valor_Transferencia = valor_Transferencia;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+((id_Transferencia == null) ? 0 : id_Transferencia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Transferencia other = (Transferencia) obj;
        if (id_Transferencia == null) {
            if(other.id_Transferencia != null)
                return false;
        }else if(!id_Transferencia.equals(other.id_Transferencia)){
            return false;
        }
        return true;
    }
}
