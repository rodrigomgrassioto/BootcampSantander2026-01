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
            case "int" ->
                    Integer.parseInt(valorBruto.trim());

            case "dec" ->
                    Double.parseDouble(valorBruto.trim());

            case "bool" ->
                    Boolean.parseBoolean(valorBruto.trim());

            case "date" ->
                    LocalDate.parse(valorBruto.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            case "datetime" ->
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
            case "2", "inteiro", "numeros inteiros", "números inteiros", "int" -> "int";
            case "3", "ponto_flutuante", "decimal", "double", "numeros com pontos flutuantes", "números com pontos flutuantes", "dec" -> "dec";
            case "4", "booleano", "boleanos", "boolean", "bool" -> "bool";
            case "5", "data", "datas", "date" -> "date";
            case "6", "data e hora", "data_hora", "datetime" -> "datetime";
            default -> "str";
        };
    }
}
