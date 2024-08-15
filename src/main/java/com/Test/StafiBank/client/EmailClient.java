package com.Test.StafiBank.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Test.StafiBank.dto.emailDto.EmailDto;
import com.Test.StafiBank.dto.emailDto.response.EmailResponse;



@FeignClient(name = "email", url= "https://12vzd.wiremockapi.cloud")// aqui nos importamos oque criamos no site
public interface EmailClient {
    
    @PostMapping(value = "/email")
    EmailResponse email(@RequestBody EmailDto emailDto);//aqui nos puxamos o post criado no site

}
