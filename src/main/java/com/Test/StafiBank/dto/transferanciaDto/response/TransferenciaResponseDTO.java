package com.Test.StafiBank.dto.transferanciaDto.response;

import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;

public class TransferenciaResponseDTO {
    private Long id;
    private Integer tipo;
    private String remetente;
    private String destinatario;

    public TransferenciaResponseDTO(){}

    public TransferenciaResponseDTO(Long id,tipoTransferenciaEnum tipo, String remetente, String destinatario){
        this.id = id;
        settipoTransferenciaEnum(tipo);
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
