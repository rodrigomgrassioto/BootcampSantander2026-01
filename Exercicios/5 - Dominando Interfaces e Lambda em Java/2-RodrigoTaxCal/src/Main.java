import com.devrodrigo.taxcalc.*;
import java.util.Scanner;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;

Scanner scanner = new Scanner(System.in);
double value = 0;
TaxCalc taxCalc = null;



void main(){
    do {
        System.out.println("==++++++=================================");
        System.out.println("========Rodrigo Calulo impostos==========");
        System.out.printf ("========++++++===========================%n%n");

        System.out.println("Bem vindo!");

        if (value <= 0) {
            System.out.print("Digite o valor a calcular: ");
            value = scanner.nextDouble(); // Limpa e engole o buffer inteiro
        } else {
            System.out.println("Qual categoria deseja calcular??");
            System.out.println("1 - Alimentação");
            System.out.println("2 - Saúde e bem estar");
            System.out.println("3 - Vestuário");
            System.out.println("4 - Cultura");
            System.out.println("5 - Comparar todas categorias");
        }
        System.out.println("0 - Sair");

        int opcao = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> taxCalc = new Alimentation(value);
            case 2-> taxCalc = () -> value * 0.015;
            case 3-> taxCalc = new Clothing(value);
            case 4-> taxCalc = new Culture(value);
            case 5-> todos();
            case 0-> System.exit(0);
            default -> System.out.println("❌ Opção inválida");
        }
        if (taxCalc != null){
            System.out.printf("Resultado = %,.2f %n", taxCalc);
            taxCalc = null;
        }

//        if (msgTodos != null && !msgTodos.isEmpty()) {
//            System.out.printf(msgTodos);
//            msgTodos = "";
    }while (true);
}

private void todos() {
    // Criamos uma lista com todos os serviços
    java.util.List<TaxCalc> category = java.util.List.of(
            new Alimentation(value), new Clothing(value), new Culture(value), new Health(value)
    );

    // Passamos a mesma mensagem como parâmetro para cada um deles
    for (TaxCalc servico : category) {
//        msgTodos += servico.sendMessage(msg);
    }
}

