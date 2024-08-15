package com.Test.StafiBank.service.exeptions;

import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;

public class EmailException extends BaseExeptionInvalid {
    private static final long serialVersionUID = 1L;
	ExceptionEnum Enum;

	public EmailException(String msg, ExceptionEnum Enum) {
		super(msg,Enum);
	}
}
