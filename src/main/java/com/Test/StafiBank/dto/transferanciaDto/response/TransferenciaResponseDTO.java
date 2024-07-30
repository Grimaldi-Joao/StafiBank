package com.Test.StafiBank.dto.transferanciaDto.response;

public class TransferenciaResponseDTO {
    private Long id;
    private String tipo;
    private String remetente;
    private String destinatario;

    public TransferenciaResponseDTO(){}

    public TransferenciaResponseDTO(Long id, String tipo, String remetente, String destinatario){
        this.id = id;
        this.tipo = tipo;
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
}
