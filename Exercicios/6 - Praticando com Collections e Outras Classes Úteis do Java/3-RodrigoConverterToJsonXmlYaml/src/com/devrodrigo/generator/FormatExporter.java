package com.devrodrigo.generator;

import java.util.Map;
import java.util.stream.Collectors;

public final class FormatExporter {
    private FormatExporter() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    // JSON
    public static String toJson(Map<String, DateField> map) {
        String mioloJson = map.entrySet().stream()
                .map(entry -> {
                    String chave = entry.getKey();
                    Object valor = entry.getValue().valorConvertido();
                    String tipo = entry.getValue().tipoOriginal();

                    // Adicionar aspas "
                    if (tipo.equals("texto") || tipo.equals("data") || tipo.equals("data_hora")) {
                        return "  \"%s\": \"%s\"".formatted(chave, valor);
                    }
                    // valores sem aspas "
                    return "  \"%s\": %s".formatted(chave, valor);
                })
                .collect(Collectors.joining(",\n")); // Junta as chaves separando por vírgula e quebra de linha

        return "{\n%s\n}".formatted(mioloJson);
    }

    // XMK
    public static String toXml(Map<String, DateField> map) {
        String tagsXml = map.entrySet().stream()
                .map(entry -> {
                    String chave = entry.getKey();
                    Object valor = entry.getValue().valorConvertido();
                    // No XML tudo vira texto dentro das tags do elemento
                    return "  <%s>%s</%s>".formatted(chave, valor, chave);
                })
                .collect(Collectors.joining("\n"));

        return "<object>\n%s\n</object>".formatted(tagsXml);
    }

    // YAML
    public static String toYaml(Map<String, DateField> map) {
        return map.entrySet().stream()
                .map(entry -> {
                    String chave = entry.getKey();
                    Object valor = entry.getValue().valorConvertido();
                    String tipo = entry.getValue().tipoOriginal();

                    // O padrão YAML aceita strings sem aspas, mas aspas duplas garantem segurança para datas/textos com espaços
                    if (tipo.equals("texto") || tipo.equals("data") || tipo.equals("data_hora")) {
                        return "%s: \"%s\"".formatted(chave, valor);
                    }
                    return "%s: %s".formatted(chave, valor);
                })
                .collect(Collectors.joining("\n")); // No YAML a separação é puramente a quebra de linha
    }
}
