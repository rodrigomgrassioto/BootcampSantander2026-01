package com.devrodrigo.messagessender;

public record SocialMedia() implements MessageSender {
    @Override
    public String sendMessage(String msg){return "✅ Enviado: "+ msg +" via Facebook.%n"; }
}
