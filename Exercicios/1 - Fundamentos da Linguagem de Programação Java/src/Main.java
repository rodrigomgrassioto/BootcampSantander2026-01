import java.time.OffsetDateTime;
import java.util.Scanner;

public class Main {
    private final static String WELLCOME_MESSAGE = "Oi, Digite seu nome: ";

    void main() {
//        IO.println(String.format("Hello and welcome!")); // método novo
        System.out.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
//            IO.println("i = " + i); // método novo
            System.out.println("i = " + i);
        }

//        Scanner scanner = new Scanner(System.in); // inicia classe que possibilita receber o conteúdo digitado pelo usuário
        var scanner = new Scanner(System.in); // inicia classe que possibilita receber o conteúdo digitado pelo usuário
        System.out.println(WELLCOME_MESSAGE); // nova linha no finalR
//        String nome = scanner.next();
        var nome = scanner.next();

//        System.out.print("Sua idade: "); // não quebra linha
//        int age = scanner.nextInt();
        System.out.print("Ano de nascimento: "); // não quebra linha
        int bornYear = scanner.nextInt();
        int baseYear = OffsetDateTime.now().getYear();
        int age = baseYear - bornYear;

        System.out.print("É emancipado? (s/n)"); // não quebra linha
        var isEmancipated = scanner.next().equalsIgnoreCase("s"); // trocar o S também retorna true

        //TIP Exercício 1
        System.out.println("Olá "+nome+" sua idade é: "+age);
        System.out.printf("Olá %s você tem %s anos \n", nome, age); // não quebra linha, por isso o \n


        //TIP Exercício 2
        System.out.print("Qual comprimento do quadrado? ");
        var quadrado = scanner.nextFloat();
        var area = quadrado*quadrado;
        System.out.println("A área do quadrado é "+area);

        //TIP Exercício 3
        System.out.print("Altura do retangulo? ");
        var aRet = scanner.nextFloat();
        System.out.print("Comprimento do retangulo? ");
        var cRet = scanner.nextFloat();
        var areaRet = aRet*cRet;
        System.out.println("A área do retângulo é "+areaRet);

        //TIP Exercício 4
        System.out.print("Nome da primeira pessoa: ");
        var nome1 = scanner.next();
        System.out.print("Idade de " + nome1 + ": ");
        var idade1 = scanner.nextInt();

        System.out.print("Nome da segunda pessoa: ");
        var nome2 = scanner.next();
        System.out.print("Idade de " + nome2 + ": ");
        var idade2 = scanner.nextInt();

        // Substituido código abaixo pois o Math.abs já faz ficar positivo
//        var difIdade = idade1-idade2;
//        if (difIdade < 0){
//            difIdade = difIdade*(-1);
//        }

        var difIdade = Math.abs(idade1 - idade2);
        System.out.println("A diferença entre as idades de " + nome1 + " e " + nome2 + " é de: " + difIdade + " anos.");
    }
}
