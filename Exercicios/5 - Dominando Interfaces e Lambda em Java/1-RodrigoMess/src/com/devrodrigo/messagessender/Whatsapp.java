package com.devrodrigo.messagessender;

public record Whatsapp() implements MessageSender {
    @Override
    public String sendMessage(String msg){return "✅ Enviado: "+ msg +" via WhatsApp.%n"; }
}
