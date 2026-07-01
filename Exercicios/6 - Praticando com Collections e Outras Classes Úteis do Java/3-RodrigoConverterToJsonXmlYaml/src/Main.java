import com.devrodrigo.generator.DateField;
import com.devrodrigo.generator.FormatExporter;
import com.devrodrigo.generator.TypeConverter;

import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;
Scanner scanner = new Scanner(System.in);
void main(){
    Map<String, DateField> objetoCustomizado = new LinkedHashMap<>();

    System.out.println("===================================");
    System.out.println("========Rodrigo converter==========");
    System.out.printf ("===================================%n%n");

    System.out.println("Bem vindo!");

    System.out.printf("%n--- GUIA DE TIPOS ACEITOS ---%n");
    System.out.println("-> texto (ou 1)");
    System.out.println("-> inteiro (ou 2)");
    System.out.println("-> decimal (ou 3)");
    System.out.println("-> booleano (ou 4)");
    System.out.println("-> data (ou 5) [Padrão: dd/mm/aaaa]");
    System.out.println("-> data_hora (ou 6) [Padrão: dd/mm/aaaa hh:mm:ss]");
    System.out.println("------------------------------------------------");
    System.out.println("Padrão de entrada: NOME_CAMPO;VALOR;TIPO;");
    System.out.println("Exemplo do Enunciado: nome;Lucas;Texto;");
    System.out.println("Digite '0' ou 'sair' a qualquer momento para encerrar e exportar.\n");

    while (true){
        System.out.print("Digite o campo (NOME;VALOR;TIPO;): ");
        String entrada = scanner.nextLine().trim();

        // Cláusula de escape unificada
        if (entrada.equals("0") || entrada.equalsIgnoreCase("sair")) {
            if (objetoCustomizado.isEmpty()) {
                System.out.println("Nenhum campo foi informado. Encerrando o sistema...");
                System.exit(0);
            }
            break; // Quebra o loop e vai para a geração dos arquivos
        }

        // separa campo digitado
        String[] partes = entrada.split(";");

        if (partes.length < 3) {
            System.out.println("❌ Entrada inválida! Deve ter 3 campos. Padrão: nome;valor;tipo;\n");
            continue;
        }
        String nomeCampo = partes[0].trim();
        String valorBruto = partes[1].trim();
        String tipoCampo  = partes[2].toLowerCase().trim();

        try {
            // Converte o valor de texto para o tipo Java correto (Integer, Double, etc.)
            Object valorProcessado = TypeConverter.converter(valorBruto, tipoCampo);

            // Normaliza o nome do tipo ("1" ou "inteiro" vira "inteiro" padronizado)
            String tipoNormalizado = TypeConverter.normalizarTipo(tipoCampo);

            // 2. ALIMENTA A GAVETA: Coloca a chave e o Record dentro do mapa que criamos lá em cima
            objetoCustomizado.put(nomeCampo, new DateField(valorProcessado, tipoNormalizado));
            System.out.printf("✅ Campo '%s' adicionado com sucesso!%n%n", nomeCampo);

        } catch (Exception e) {
            System.out.printf("❌ Erro de conversão: O valor '%s' não corresponde ao tipo '%s'. Tente novamente.%n%n", valorBruto, tipoCampo);
        }

    }

    System.out.println("\n================================================");
    System.out.println("📊 PROCESSAMENTO CONCLUÍDO - EXPORTANDO FORMATOS");
    System.out.println("================================================");

    System.out.println("\n🚀 [JSON]");
    System.out.println(FormatExporter.toJson(objetoCustomizado));

    System.out.println("\n🚀 [XML]");
    System.out.println(FormatExporter.toXml(objetoCustomizado));

    System.out.println("\n🚀 [YAML]");
    System.out.println(FormatExporter.toYaml(objetoCustomizado));

//    System.out.println("Para encerrar o programa digite '0' (ZERO)");
//    System.out.print("Digite a chave e valor(separado por ';'): ");
//    var keyValue  = scanner.nextLine();
//    if (keyValue.equals("0")) System.exit(1);
//
//    int option = -1;
//    while (option <= 0 || option > 4){
//        System.out.println("Para encerrar o programa digite '0' (ZERO)");
//        System.out.println("==== Escolha: ===");
//        System.out.println("1 -> Inteiro");
//        System.out.println("2 -> Decima");
//        System.out.println("3 -> Data(dd/mm/aaaa)");
//        System.out.println("4 -> Verdadeiro ou falso");
//        option = lerNumeroSeguro("Valor escolhido:", "int").intValue();
//        if (option == 0) System.exit(0);
//        else System.out.printf("digitou: %s", option);
//        if (option != 1 && option != 2){
//            System.out.println("Opção inválida.");
//        }
//    }
//    var selectedOperation = Operation.values()[option - 1];
//
//    System.out.print("Digite os números separados por virgula (ex: 1,2,3,4,5): ");
//    // aceita usuário digitar espaço, mas remove este espaço antes de gerar o array.
//    var numbers = scanner.nextLine().replace(" ", "");
//    var numberArray = Arrays.stream(numbers.split(","))
//            .mapToLong(Long::parseLong)
//            .toArray();
//
//    var result = selectedOperation.getOperationCallbackTest().exec(numberArray);
//    var operationShow = numbers.replaceAll(",", selectedOperation.getSignal());
//    System.out.printf("Resultado de %s = %s%n", operationShow,  result);
}