import com.devrodrigo.area.Circle;
import com.devrodrigo.area.GeometricShape;
import com.devrodrigo.area.Rectangle;
import com.devrodrigo.area.Square;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;

GeometricShape geometricShape;

void main(){
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
        System.out.printf("A área é: %,.2f %n%n", geometricShape.getArea());
    }while (true);
}
private void square(){
    double comp = lerNumeroSeguro("Comprimento do quadrado: ", "dou").doubleValue();
    // sem utilizar a interface
//    double result = new Square(comp).getArea();
//    System.out.printf("A área do quadrado é: %,.2f %n", result);
    geometricShape = new Square(comp);
}

public void rectangle(){
    double comp = lerNumeroSeguro("Comprimento do retângulo: ", "dou").doubleValue();
    double larg = lerNumeroSeguro("Largura do retângulo: ", "dou").doubleValue();

    // usando record
    // geometricShape = new Rectangle(comp, larg);

    //usando LAMBIDA (similar a arrow function, função anônima no JS)
    geometricShape = () -> comp * larg;
}

public void circle(){
    double raio = lerNumeroSeguro("Rádio do cirgulo: ", "dou").doubleValue();
    geometricShape = new Circle(raio);
}