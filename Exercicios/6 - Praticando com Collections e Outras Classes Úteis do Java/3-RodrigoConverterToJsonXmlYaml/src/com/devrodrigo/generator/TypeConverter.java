package com.devrodrigo.generator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TypeConverter {

    private TypeConverter() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    // converte texto para formato selecionado
    public static Object converter(String valorBruto, String codigoTipo) {
        if (valorBruto == null || codigoTipo == null) {
            return "";
        }

        String codigo = codigoTipo.trim();

        return switch (codigo) {
            case "2" -> Integer.parseInt(valorBruto.trim());

            case "3" -> Double.parseDouble(valorBruto.trim());

            case "4" -> LocalDate.parse(valorBruto.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            case "5" -> Boolean.parseBoolean(valorBruto.trim());

            // Se digitar 1 ou qualquer outra coisa, vira texto por padrão
            default -> valorBruto;
        };
    }
}
