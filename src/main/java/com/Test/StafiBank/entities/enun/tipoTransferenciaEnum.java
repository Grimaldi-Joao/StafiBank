package com.Test.StafiBank.entities.enun;

public enum tipoTransferenciaEnum {
    Usuario_Usuario (1),
    Usuario_Loja(2);

    private int code;

    private tipoTransferenciaEnum(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }

        public static tipoTransferenciaEnum valueOf(int code){
        for(tipoTransferenciaEnum value: tipoTransferenciaEnum.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
