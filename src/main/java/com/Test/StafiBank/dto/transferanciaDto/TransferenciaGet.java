package com.Test.StafiBank.dto.transferanciaDto;

import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;

public class TransferenciaGet {

    private Long id;
    private Integer tipo;
    private String remetente;
    private String destinatario;

    public TransferenciaGet(){}

    public TransferenciaGet(Long id, tipoTransferenciaEnum tipo, String remetente, String destinatario){
        this.id = id;
        settipoTransferenciaEnum(tipo);
        this.remetente = remetente;
        this.destinatario = destinatario;
    }
    
    public TransferenciaGet(Transferencia Obj) {
        this.id = Obj.getId_Transferencia();
        settipoTransferenciaEnum(Obj.gettipoTransferenciaEnum());
        this.remetente = Obj.getRemetente().getFk_Usuario_Id().getNome();
        this.destinatario = Obj.getDestinatario().getFk_Usuario_Id().getNome();
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
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    public tipoTransferenciaEnum gettipoTransferenciaEnum() {
        return tipoTransferenciaEnum.valueOf(tipo);
    }
    public void settipoTransferenciaEnum(tipoTransferenciaEnum tipoTransferenciaEnum) {
        if (tipoTransferenciaEnum != null) {
            this.tipo = tipoTransferenciaEnum.getCode();
        }
    }
}
