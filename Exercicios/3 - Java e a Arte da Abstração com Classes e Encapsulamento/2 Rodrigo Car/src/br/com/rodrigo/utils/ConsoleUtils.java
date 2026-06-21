package br.com.rodrigo.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private final static Scanner scanner = new Scanner(System.in);

    private static Number lerNumeroSeguro(String mensagem, String tipo) {
        while (true) {
            System.out.println(mensagem);
            String entrada = scanner.nextLine(); // Limpa e engole o buffer inteiro

            if (entrada.trim().isEmpty()) {
                System.out.println("⚠️ O campo não pode ficar em branco.");
                continue;
            }

            try {
                String textoLimpo = entrada.trim();

                // Usamos .equalsIgnoreCase para aceitar "int", "INT", "dou", "DOU" de forma segura
                if (tipo.equalsIgnoreCase("int")) {
                    return Integer.parseInt(textoLimpo); // Retorna um número Inteiro
                } else if (tipo.equalsIgnoreCase("dou")) {
                    return Double.parseDouble(textoLimpo); // Retorna um número Double
                }

            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Digite apenas números.");
            }
        }
    }
}
