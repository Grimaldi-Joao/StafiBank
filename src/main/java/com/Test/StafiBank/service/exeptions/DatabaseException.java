package com.Test.StafiBank.service.exeptions;

import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;

public class DatabaseException extends BaseExeptionInvalid {
	private static final long serialVersionUID = 1L;
	ExceptionEnum Enum;

	public DatabaseException(String msg, ExceptionEnum Enum) {
		super(msg,Enum);
	}
	public ExceptionEnum getEnum() {
        return Enum;
    }
}

