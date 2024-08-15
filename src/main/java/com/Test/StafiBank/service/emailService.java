package com.Test.StafiBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.StafiBank.client.EmailClient;
import com.Test.StafiBank.dto.emailDto.EmailDto;
import com.Test.StafiBank.resource.exptions.enuns.ExceptionEnum;
import com.Test.StafiBank.service.exeptions.EmailException;

@Service
public class emailService {
    
    @Autowired
    private EmailClient client; 

    public void enviarEmail(EmailDto emailDto) {
        try {
        	// mudar p enviaremail
            client.email(emailDto); // chamando o post e eviar o email e enviando
        } catch (Exception e) {
            throw new EmailException("Email invalido", ExceptionEnum.Email_invalid); // se der errado lança essa exceção //adicionar um erro
        }
    }
}
