import com.devrodrigo.calc.Operation;

import java.util.Scanner;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;
Scanner scanner = new Scanner(System.in);
void main(){
    System.out.println("==============================");
    System.out.println("========Rodrigo Calc==========");
    System.out.printf ("==============================%n%n");

    System.out.println("Bem vindo!");
    System.out.println("1 - Somar");
    System.out.println("2 - Subtrair");
    System.out.println("0 - Sair");

    int option = -1;
    while (option < 1 || option > 2){
        option = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();
        if (option == 0) System.exit(0);
        if (option != 1 && option != 2){
            System.out.println("Opção inválida.");
        }
    }
    var selectedOperation = Operation.values()[option - 1];

    System.out.print("Digite os números separados por virgula (ex: 1,2,3,4,5): ");
    var numbers = scanner.next();
    var numberArray = Arrays.stream(numbers.split(","))
            .mapToLong(Long::parseLong)
            .toArray();

    var result = selectedOperation.getOperationCallback().exec(numberArray);
    var operationShow = numbers.replaceAll(",", selectedOperation.getSignal());
    System.out.printf("Resultado de %s= %s%n", operationShow,  result);
}