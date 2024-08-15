package com.Test.StafiBank.resource.exptions;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Test.StafiBank.service.exeptions.BaseExeptionInvalid;
import com.Test.StafiBank.service.exeptions.DatabaseException;
import com.Test.StafiBank.service.exeptions.EmailException;
import com.Test.StafiBank.service.exeptions.IllegalArgument;
import com.Test.StafiBank.service.exeptions.InsufficientBalanceException;
import com.Test.StafiBank.service.exeptions.ResourceNotFoundException;
import com.Test.StafiBank.service.exeptions.illegaltransitionargument;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
        @ExceptionHandler(ResourceNotFoundException.class)//essa anotatio dará para a excessão que estamos interceptando(a qual está dentro dos parenteses), o tratamento que estamos implementando a baixo 
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;//como esse erro é de não encontrar o ID aqui estamos usando o 404 not faund
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(),e.getEnum(), request.getRequestURI());// criamos um standart erro para altera-lo com nossas novas informações
		return ResponseEntity.status(status).body(err);
	}

    @ExceptionHandler({DatabaseException.class , EmailException.class})
	public ResponseEntity<StandardError> database(BaseExeptionInvalid e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		System.out.println(e.getMessage());
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), e.getEnum(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler({InsufficientBalanceException.class, IllegalArgument.class,illegaltransitionargument.class,InsufficientBalanceException.class})
	public ResponseEntity<StandardError> Invalid(BaseExeptionInvalid e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(),e.getEnum() , request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
