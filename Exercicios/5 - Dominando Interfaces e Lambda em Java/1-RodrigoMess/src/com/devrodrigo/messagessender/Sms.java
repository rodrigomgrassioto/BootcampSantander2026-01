package com.devrodrigo.messagessender;

public record Sms() implements MessageSender {

    @Override
    public String sendMessage(String msg){return "✅ Enviado: "+ msg +" via SMS.%n"; }
}
