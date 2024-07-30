package com.Test.StafiBank.dto.transferanciaDto;

import com.Test.StafiBank.entities.Conta;

public record TransferenciaGet(Long id, String tipo, Conta remetente, Conta destinatario) {

}
