package com.devrodrigo.phone;

public final class PhoneFormater {
    private PhoneFormater() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    public static PhoneResponse processarTelefone(String unformattedNumber) {
        if (unformattedNumber == null || unformattedNumber.isBlank()) {
            return new PhoneResponse("", "Desconhecido", false, "Número não pode ser vazio.");
        }

        // Retirar todos caractéres que não sejam números
        String apenasNumeros = unformattedNumber.replaceAll("\\D", "");

        // Celular
        if (apenasNumeros.length() == 11) {
            String formatado = apenasNumeros.replaceAll("(\\d{2})(\\d{1})(\\d{4})(\\d{4})", "($1) $2 $3-$4");
            return new PhoneResponse(formatado, "Celular", true, "Telefone celular processado com sucesso.");
        }

        // Fixo
        if (apenasNumeros.length() == 10) {
            String formatado = apenasNumeros.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
            return new PhoneResponse(formatado, "Fixo", true, "Telefone fixo processado com sucesso.");
        }

        // Se não tiver 10 ou 11 digitos, Falha de Validação
        return new PhoneResponse(
                unformattedNumber,
                "Inválido",
                false,
                "Falha: O telefone (+ DDD) precisa ter 10 ou 11 números (Fixo/Celular):"
        );
    }
}
