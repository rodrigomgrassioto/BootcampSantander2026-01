package com.devrodrigo;

import com.devrodrigo.config_singleton.SystemConfig;
import com.devrodrigo.strategy.EmailStrategy;
import com.devrodrigo.strategy.SmsStrategy;

import java.util.Objects;

public class Main {
    public static void main(){
        SystemConfig config = SystemConfig.getInstance();
        SystemConfig config2 = SystemConfig.getInstance();
        System.out.println(config); // sempre mesmo endereço de memória
        System.out.println(config2); // sempre mesmo endereço de memória
        System.out.println(config.getEnvironment());

        if (!Objects.equals(config.getEnvironment(), "PRODUCTION")){
            System.out.println("Fim teste desenvolvimento.");
            return;
        }
        var client = "Rodrigo";
        var cellPhone = "12345678901";
        var msg = "Bem Vindo "+ client;

        EmailStrategy emailStrategy = new EmailStrategy();
        emailStrategy.send(cellPhone, msg);

        SmsStrategy smsStrategy = new SmsStrategy();
        smsStrategy.send(cellPhone, msg);

    }
}
