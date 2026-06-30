import java.util.Scanner;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;
Scanner scanner = new Scanner(System.in);
void main(){

//    do {
    System.out.println("==============================");
    System.out.println("========Rodrigo Calc==========");
    System.out.printf ("==============================%n%n");

    System.out.println("Bem vindo!");


    System.out.println("1 - Somar");
    System.out.println("2 - Subtrair");
//        System.out.println("3 - Saúde e bem estar");
//        System.out.println("4 - Vestuário");
//        System.out.println("5 - Cultura");
//        System.out.println("6 - Comparar todas categorias");

    System.out.println("0 - Sair");

    int option = -1;

    while (option < 1 || option > 2){
        option = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();
        if (option == 0) System.exit(0);
        if (option != 1 && option != 2){
            System.out.println("Opção inválida.");
        }
    }
    System.out.print("Digite os números separados por virgula (ex: 1,2,3,4,5): ");
    var numbers = scanner.next();
    var numberArray = Arrays.stream(numbers.split(","))
            .mapToLong(Long::parseLong)
            .toArray();


//        switch (option) {
//            case 1-> {
//                System.out.print("Digite o valor base: ");
//                value = scanner.nextDouble();
//            }
//            case 2-> taxCalc = new Alimentation(value);
//            case 3-> taxCalc = () -> value * 0.015;
//            case 4-> taxCalc = new Clothing(value);
//            case 5-> taxCalc = new Culture(value);
//            case 6-> todos();
//            case 0-> System.exit(0);
//            default -> System.out.println("❌ Opção inválida");
//        }
//        if (taxCalc != null){
//            System.out.printf("Resultado = %,.2f %n", taxCalc.calcTax());
////            System.out.printf("Resultado = %s %n", taxCalc.calcTax());
//            taxCalc = null;
//        }
//
//        if (msgTodos != null && !msgTodos.isEmpty()) {
//            System.out.printf(msgTodos);
//            msgTodos = "";
//        }
//    }while (true);
//}
//
//private void todos() {
//    // lista com Records
//    List<TaxCalc> category = List.of(
//            new Alimentation(value),new Health(value), new Clothing(value), new Culture(value)
//    );
//    msgTodos = "Comparação de impostor por categoria.%n";
//    msgTodos += "Valor de base: "+value+"%n";
//
//    // Passamos a mesma mensagem como parâmetro para cada um deles
//    for (TaxCalc servico : category) {
//        if (servico instanceof Alimentation) {
//            msgTodos += "Alimentação: "+servico.calcTax()+"%n";
//        }
//        if (servico instanceof Health) {
//            msgTodos += "Saúde e bem estar: "+servico.calcTax()+"%n";
//        }
//        if (servico instanceof Clothing) {
//            msgTodos += "Vestuário: "+servico.calcTax()+"%n";
//        }
//        if (servico instanceof Culture) {
//            msgTodos += "Cultura: "+servico.calcTax()+"%n";
//        }
//    }
}
