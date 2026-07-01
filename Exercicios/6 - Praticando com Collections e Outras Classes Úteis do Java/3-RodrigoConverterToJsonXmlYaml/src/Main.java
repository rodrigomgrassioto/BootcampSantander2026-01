import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;
Scanner scanner = new Scanner(System.in);
void main(){
    System.out.println("===================================");
    System.out.println("========Rodrigo converter==========");
    System.out.printf ("===================================%n%n");

    System.out.println("Bem vindo!");
    int numberFields = -1;
    while (numberFields <= 0){
        System.out.println("Para encerrar o programa digite '0' (ZERO)");
        numberFields = lerNumeroSeguro("Quantidade de campos: ", "int").intValue();
        if (numberFields == 0) System.exit(1);
    }
    System.out.println("Para encerrar o programa digite '0' (ZERO)");
    System.out.print("Digite a chave e valor(separado por ';'): ");
    var keyValue  = scanner.nextLine();
    if (keyValue.equals("0")) System.exit(1);

    int option = -1;
    while (option <= 0 || option > 4){
        System.out.println("Para encerrar o programa digite '0' (ZERO)");
        System.out.println("==== Escolha: ===");
        System.out.println("1 -> Inteiro");
        System.out.println("2 -> Decima");
        System.out.println("3 -> Data(dd/mm/aaaa)");
        System.out.println("4 -> Verdadeiro ou falso");
        option = lerNumeroSeguro("Valor escolhido:", "int").intValue();
        if (option == 0) System.exit(0);
        else System.out.printf("digitou: %s", option);
//        if (option != 1 && option != 2){
//            System.out.println("Opção inválida.");
//        }
    }
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