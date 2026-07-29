package com.devrodrigo.facade;
import com.devrodrigo.config_singleton.SystemConfig;
import com.devrodrigo.strategy.EmailStrategy;
import com.devrodrigo.strategy.NotificationStrategy;
import com.devrodrigo.strategy.SmsStrategy;

public class NotificationFacade {
    private final SystemConfig config = SystemConfig.getInstance();

    public void sendWelcomeNotification(String userEmail, String userPhone) {
        System.out.println("Ambiente atual: " + config.getEnvironment());

        NotificationStrategy email = new EmailStrategy();
        email.send(userEmail, "Bem-vindo ao nosso sistema!");

        NotificationStrategy sms = new SmsStrategy();
        sms.send(userPhone, "Seu cadastro foi realizado com sucesso!");
    }
}
