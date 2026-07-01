package com.devrodrigo.phone;

public final class PhoneFormater {
    private PhoneFormater() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    public static PhoneResponse formatPhone(String unformattedNumber) {
        if (unformattedNumber == null || unformattedNumber.isBlank()) {
            return new PhoneResponse("", "Desconhecido", false, "Número não pode ser vazio.");
        }

        // Apenas números, tmbm vai atender o requisito de: se receber nr formatado deverá retornar formatado
        String onlyNumbers = unformattedNumber.replaceAll("\\D", "");

        // DDD + Celular
        if (onlyNumbers.length() == 11) {
//            String formatado = onlyNumbers.replaceAll("(\\d{2})(\\d{1})(\\d{4})(\\d{4})", "($1) $2 $3-$4"); // com espaço no nono dígito
            String formatado = onlyNumbers.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
            return new PhoneResponse(formatado, "DDD+CELULAR", true, "DDE + celular processado com sucesso.");
        }

        // DDD + Fixo
        if (onlyNumbers.length() == 10) {
            String formatado = onlyNumbers.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
            return new PhoneResponse(formatado, "DDD+FIXO", true, "DDD + fixo processado com sucesso.");
        }

        // Apenas Cel - quase esqueci do requisito sem DDD
        if (onlyNumbers.length() == 9){
            String formatado = onlyNumbers.replaceAll("(\\d{5})(\\d{4})", "$1-$2");
            return new PhoneResponse(formatado, "APENAS_CELULAR", true, "Celular sem DDD processado com sucesso.");
        }

        // Apenas fixo
        if (onlyNumbers.length() == 8){
            String formatado = onlyNumbers.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
            return new PhoneResponse(formatado, "APENAS_FIXO", true, "Telefone fixo sem DDD processado com sucesso.");
        }

        // Se não tiver 8 e 11 digitos, Falha de Validação
        return new PhoneResponse(
                unformattedNumber,
                "INVÁLIDO",
                false,
                "Falha: O telefone precisa ter entre 8 e 11 números (Fixo/Celular Com/Sem DDD):"
        );
    }
}
