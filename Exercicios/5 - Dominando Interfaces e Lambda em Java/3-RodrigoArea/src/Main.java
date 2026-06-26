import com.devrodrigo.area.Circle;
import com.devrodrigo.area.Rectangle;
import com.devrodrigo.area.Square;

import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;

void main() {

    do {
        System.out.println("==++++++==========================");
        System.out.println("========Rodrigo Área Calc=========");
        System.out.printf ("========++++++====================%n%n");

        System.out.println("Bem vindo!");
        System.out.println("Escolha o tipo Geométrico.");
        System.out.println("1 - Quadrado");
        System.out.println("2 - Retângulo");
        System.out.println("3 - Círculo");
        System.out.println("0 - Sair");

        int opcao = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> square();
            case 2-> rectangle();
            case 3-> circle();
            case 0-> System.exit(0);
            default -> System.out.println("❌ Opção inválida");
        }
    }while (true);
}

public void square(){
    double comp = lerNumeroSeguro("Comprimento do quadrado: ", "dou").doubleValue();
    double result = new Square(comp).getArea();
    System.out.printf("A área do quadrado é: %,.2f %n", result);
}

public void rectangle(){
    double comp = lerNumeroSeguro("Comprimento do retângulo: ", "dou").doubleValue();
    double larg = lerNumeroSeguro("Largura do retângulo: ", "dou").doubleValue();
    double result = new Rectangle(comp, larg).getArea();
    System.out.printf("A área do retângulo é: %,.2f %n", result);
}

public void circle(){
    double raio = lerNumeroSeguro("Rádio do cirgulo: ", "dou").doubleValue();
    double result = new Circle(raio).getArea();
    System.out.printf("A área do círculo é: %,.2f %n", result);
}