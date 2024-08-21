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
    private Long idConta;
    private BigDecimal Carteira;

    @ManyToOne
    @JoinColumn(name = "fk_Usuario_Id") // Chave estrangeira referenciando Usuario
    private Usuario fkUsuarioId;

    @OneToMany(mappedBy = "remetente")
    private List<Transferencia> transferenciasRemetente;

    @OneToMany(mappedBy = "destinatario")
    private List<Transferencia> transferenciasDestinatario;

    public Conta() {
    }

    public Conta(Long id, Usuario Usuario) {
        super();
        this.idConta = id;
        this.Carteira = new BigDecimal(0.0);
        this.fkUsuarioId = Usuario;
    }

    public Long getidConta() {
        return idConta;
    }

    public BigDecimal getCarteira() {
        return Carteira;
    }

    public Usuario getfkUsuarioId() {
        return fkUsuarioId;
    }

    public List<Transferencia> getTransferenciasDestinatario() {
        return transferenciasDestinatario;
    }

    public List<Transferencia> getTransferenciasRemetente() {
        return transferenciasRemetente;
    }

    public void setidConta(Long idConta) {
        this.idConta = idConta;
    }

    public void setCarteira(BigDecimal carteira) {
        this.Carteira = carteira;
    }

    public void setfkUsuarioId(Usuario fkUsuarioId) {
        this.fkUsuarioId = fkUsuarioId;
    }

    public void setTransferenciasDestinatario(List<Transferencia> transferenciasDestinatario) {
        this.transferenciasDestinatario = transferenciasDestinatario;
    }

    public void setTransferenciasRemetente(List<Transferencia> transferenciasRemetente) {
        this.transferenciasRemetente = transferenciasRemetente;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (idConta == null) {
            if (other.idConta != null)
                return false;
        } else if (!idConta.equals(other.idConta)) {
            return false;
        }
        return true;
    }
}
