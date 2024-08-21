package com.Test.StafiBank.dto.transferanciaDto.response;

import java.time.LocalDateTime;

import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;

public class TransferenciaResponseDTO {
    private Long id;
    private Integer tipo;
    private String remetente;
    private String destinatario;
    private LocalDateTime momento;

    public TransferenciaResponseDTO(){}

    public TransferenciaResponseDTO(Long id,tipoTransferenciaEnum tipo, String remetente, String destinatario, LocalDateTime momento){
        this.id = id;
        setTipoTransferenciaEnum(tipo);
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.momento = momento;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
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
    public tipoTransferenciaEnum getTipoTransferenciaEnum() {
        return tipoTransferenciaEnum.valueOf(tipo);
    }
    public void setTipoTransferenciaEnum(tipoTransferenciaEnum tipoTransferenciaEnum) {
        if (tipoTransferenciaEnum != null) {
            this.tipo = tipoTransferenciaEnum.getCode();
        }
    }
}
