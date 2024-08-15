package com.Test.StafiBank.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Conta;
    private BigDecimal Carteira;

    @ManyToOne
    @JoinColumn(name = "fk_usuario_id") // Chave estrangeira referenciando Usuario
    private Usuario fk_Usuario_Id;

    @OneToMany(mappedBy = "remetente")
    private List<Transferencia> transferenciasRemetente;
    
    @OneToMany(mappedBy = "destinatario")
    private List<Transferencia> transferenciasDestinatario;

    public Conta(){}

    public Conta(Long id, Usuario Usuario){
        super();
        this.id_Conta = id;
        this.Carteira = new BigDecimal(0.0);
        this.fk_Usuario_Id = Usuario;
    }

    public Long getId_Conta() {
        return id_Conta;
    }
    public BigDecimal getCarteira() {
        return Carteira;
    }
    public Usuario getFk_Usuario_Id() {
        return fk_Usuario_Id;
    }
    public List<Transferencia> getTransferenciasDestinatario() {
        return transferenciasDestinatario;
    }
    public List<Transferencia> getTransferenciasRemetente() {
        return transferenciasRemetente;
    }

    public void setId_Conta(Long id_Conta) {
        this.id_Conta = id_Conta;
    }
    public void setCarteira(BigDecimal carteira) {
        this.Carteira = carteira;
    }
    public void setFk_Usuario_Id(Usuario fk_Usuario_Id) {
        this.fk_Usuario_Id = fk_Usuario_Id;
    }

    public void setTransferenciasDestinatario(List<Transferencia> transferenciasDestinatario) {
        this.transferenciasDestinatario = transferenciasDestinatario;
    }
    public void setTransferenciasRemetente(List<Transferencia> transferenciasRemetente) {
        this.transferenciasRemetente = transferenciasRemetente;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+((id_Conta == null) ? 0 : id_Conta.hashCode());
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
        Conta other = (Conta) obj;
        if (id_Conta == null) {
            if(other.id_Conta != null)
                return false;
        }else if(!id_Conta.equals(other.id_Conta)){
            return false;
        }
        return true;
    }
}
