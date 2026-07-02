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

            case "bool" -> {
                String valor = valorBruto.toLowerCase().trim();
                if (valor.equals("true") || valor.equals("verdade") || valor.equals("sim") || valor.equals("v") || valor.equals("1")) {
                    yield true;
                }
                yield false;

            }
            case "date" -> {
                // mantém apenas números
                String apenasNumeros = valorBruto.replaceAll("\\D", "");

                if (apenasNumeros.length() != 8) {
                    throw new IllegalArgumentException("❌ Data inválida. Precisa conter exatamente 8 dígitos numéricos.");
                }

                String dataFormatada = apenasNumeros.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
                yield LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
            case "datetime" -> {
                String onlyNumbers = valorBruto.replaceAll("\\D", "");

                // Se o usuário não digitou os segundos, adiciona "00" no final
                if (onlyNumbers.length() == 12)  onlyNumbers = onlyNumbers + "00"; // "230319821433" vira "23031982143300"
                if (onlyNumbers.length() != 14) throw new IllegalArgumentException("❌ Data e hora inválidas. Precisa conter 12 ou 14 dígitos numéricos.");

                String dataHoraFormatada = onlyNumbers.replaceAll(
                        "(\\d{2})(\\d{2})(\\d{4})(\\d{2})(\\d{2})(\\d{2})",
                        "$1/$2/$3 $4:$5:$6"
                );

                yield LocalDateTime.parse(dataHoraFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            }

            // Caso seja "1", "texto" ou qualquer outra string, mantém como texto puro
            default -> valorBruto;
        };
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
