package com.Test.StafiBank.entities.enun;

public enum tipoEnum {
    Usuario(1),
    Loja(2);

    private int code;

    private tipoEnum(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }

        public static tipoEnum valueOf(int code){
        for(tipoEnum value: tipoEnum.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
