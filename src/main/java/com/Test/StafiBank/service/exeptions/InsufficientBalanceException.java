package com.Test.StafiBank.service.exeptions;

import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;

public class InsufficientBalanceException extends BaseExeptionInvalid {
	private static final long serialVersionUID = 1L;
	ExceptionEnum Enum;

	public InsufficientBalanceException(String msg, ExceptionEnum Enum) {
		super(msg,Enum);
	}
}
