package com.devrodrigo.messagessender;

public record Email() implements MessageSender {
    @Override
    public String sendMessage(String msg){return "✅ Enviado: "+ msg +" via E-Mail.%n"; }
}
