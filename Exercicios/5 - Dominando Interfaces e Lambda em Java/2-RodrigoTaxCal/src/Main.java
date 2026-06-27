import com.devrodrigo.taxcalc.*;
import java.util.Scanner;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;

Scanner scanner = new Scanner(System.in);
double value = 0;
TaxCalc taxCalc = null;
String msgTodos = "";

void main(){
    do {
        System.out.println("==++++++=================================");
        System.out.println("========Rodrigo Calulo impostos==========");
        System.out.printf ("========++++++===========================%n%n");

        System.out.println("Bem vindo!");

        if (value <= 0) {
            System.out.println("1 - Informar valor base");
        } else if (value > 0){
            System.out.println("1 - Trocar valor base:");
            System.out.println("2 - Alimentação");
            System.out.println("3 - Saúde e bem estar");
            System.out.println("4 - Vestuário");
            System.out.println("5 - Cultura");
            System.out.println("6 - Comparar todas categorias");
        }
        System.out.println("0 - Sair");

        int opcao = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> {
                System.out.print("Digite o valor base: ");
                value = scanner.nextDouble();
            }
            case 2-> taxCalc = new Alimentation(value);
            case 3-> taxCalc = () -> value * 0.015;
            case 4-> taxCalc = new Clothing(value);
            case 5-> taxCalc = new Culture(value);
            case 6-> todos();
            case 0-> System.exit(0);
            default -> System.out.println("❌ Opção inválida");
        }
        if (taxCalc != null){
            System.out.printf("Resultado = %,.2f %n", taxCalc.calcTax());
//            System.out.printf("Resultado = %s %n", taxCalc.calcTax());
            taxCalc = null;
        }

        if (msgTodos != null && !msgTodos.isEmpty()) {
            System.out.printf(msgTodos);
            msgTodos = "";
        }
    }while (true);
}

private void todos() {
    // lista com Records
    java.util.List<TaxCalc> category = java.util.List.of(
            new Alimentation(value),new Health(value), new Clothing(value), new Culture(value)
    );
    msgTodos = "Comparação de impostor por categoria.%n";
    msgTodos += "Valor de base: "+value+"%n";

    // Passamos a mesma mensagem como parâmetro para cada um deles
    for (TaxCalc servico : category) {
        if (servico instanceof Alimentation) {
            msgTodos += "Alimentação: "+servico.calcTax()+"%n";
        }
        if (servico instanceof Health) {
            msgTodos += "Saúde e bem estar: "+servico.calcTax()+"%n";
        }
        if (servico instanceof Clothing) {
            msgTodos += "Vestuário: "+servico.calcTax()+"%n";
        }
        if (servico instanceof Culture) {
            msgTodos += "Cultura: "+servico.calcTax()+"%n";
        }
    }
}
