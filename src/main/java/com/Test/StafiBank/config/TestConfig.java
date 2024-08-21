package com.Test.StafiBank.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import com.Test.StafiBank.entities.Conta;
import com.Test.StafiBank.entities.Transferencia;
import com.Test.StafiBank.entities.Usuario;
import com.Test.StafiBank.entities.enun.tipoEnum;
import com.Test.StafiBank.entities.enun.tipoTransferenciaEnum;
import com.Test.StafiBank.repository.ContaRepository;
import com.Test.StafiBank.repository.TransferenciaRepository;
import com.Test.StafiBank.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario( null, "Joao", "joao@gmail.com", tipoEnum.Usuario,"1234", "123");
        Conta conta1 = new Conta(null, usuario1);
        Usuario usuario2 = new Usuario(null,"Maria","maria@gmail.com",tipoEnum.Usuario,"12345","1234");
        Conta conta2 = new Conta(null,usuario2);
        
        BigDecimal valor = new BigDecimal("100.00");
        conta1.getCarteira().add(valor);
        
        Transferencia transferencia1 = new Transferencia(tipoTransferenciaEnum.Usuario_Usuario, new BigDecimal(100.00), conta1, conta2, LocalDateTime.now());
        
        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));
        contaRepository.saveAll(Arrays.asList(conta1,conta2));
        transferenciaRepository.saveAll(Arrays.asList(transferencia1));
    }
    
}
