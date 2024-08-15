package com.Test.StafiBank.service.exeptions;

import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;

public class IllegalArgument extends BaseExeptionInvalid {
    private static final long serialVersionUID = 1L;
	ExceptionEnum Enum;

	public IllegalArgument(String msg, ExceptionEnum Enum) {
		super(msg,Enum);
	}
	public ExceptionEnum getEnum() {
        return Enum;
    }
}
