package com.devrodrigo.generator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TypeConverter {

    private TypeConverter() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    // converte texto para formato selecionado
    public static Object converter(String valorBruto, String tipo) {
        if (valorBruto == null || tipo == null) {
            return "";
        }

        String t = tipo.toLowerCase().trim();

        // Aceitamos tanto o número do menu quanto as palavras descritas no enunciado!
        return switch (t) {
            case "2", "inteiro", "numeros inteiros" ->
                    Integer.parseInt(valorBruto.trim());

            case "3", "ponto_flutuante", "decimal", "double", "números com pontos flutuantes" ->
                    Double.parseDouble(valorBruto.trim());

            case "4", "booleano", "boleanos", "boolean", "bool" ->
                    Boolean.parseBoolean(valorBruto.trim());

            case "5", "data", "datas", "date" ->
                    LocalDate.parse(valorBruto.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            case "6", "data e hora", "data_hora", "datetime" ->
                    LocalDateTime.parse(valorBruto.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            // Caso seja "1", "texto" ou qualquer outra string, mantém como texto puro
            default -> valorBruto;
        };

        // não atende os requisitos
//        return switch (codigo) {
//            case "2" -> Integer.parseInt(valorBruto.trim());
//
//            case "3" -> Double.parseDouble(valorBruto.trim());
//
//            case "4" -> LocalDate.parse(valorBruto.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//            case "5" -> Boolean.parseBoolean(valorBruto.trim());
//
//            // Se digitar 1 ou qualquer outra coisa, vira texto por padrão
//            default -> valorBruto;
//        };
    }

    public static String normalizarTipo(String tipo) {
        String t = tipo.toLowerCase().trim();
        return switch (t) {
            case "2", "inteiro", "numeros inteiros" -> "inteiro";
            case "3", "ponto_flutuante", "decimal", "double", "números com pontos flutuantes" -> "decimal";
            case "4", "booleano", "boleanos", "boolean", "bool" -> "booleano";
            case "5", "data", "datas", "date" -> "data";
            case "6", "data e hora", "data_hora", "datetime" -> "data_hora";
            default -> "texto";
        };
    }
}
