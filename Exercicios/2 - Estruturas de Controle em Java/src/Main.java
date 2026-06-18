void main() {
    //TIP Exercício 1
    var scanner =new Scanner(System.in);
    System.out.println("===== Gerador de tabuada =====");
    System.out.print("Digite um número:");
    var number = scanner.nextInt();

    System.out.println("===== Tabuada gerada =====");
    for (var i = 1; i <= 10; i++){
        System.out.printf("%s x %s = %s\n", number, i, (number*i));
    }
    System.out.println("Fim exercício 1");


    //TIP Exercício 2
    System.out.println("===== Cálculo do IMC (Índice de massa corporal) =====");
    System.out.print("Digite o peso \n:");
    var peso = scanner.nextDouble();
    System.out.print("Digite a altura em cm \n:");
    var altura = scanner.nextDouble();
    altura = altura/100;
    double imc = peso / (altura*altura);
    //TIP <b>Novidades switch a partir da versão 26</b><br>
    // <br>
    // *** NECESSÁRIO UTILIZAR : ***
    // "26 (Preview) - Primitive types in patterns (4th preview)."<br>
    // <br>
    // * possibilidade de trabalhar com range usando o when.<br>
    // * se usar -> ao invés de : não precisa do break
    switch (imc) {
        case double i when i <= 18.5 -> {
            System.out.printf("IMC: %.2f - Abaixo do peso%n", imc);
        }
        case double i when i <= 24.9 -> {
            System.out.printf("IMC: %.2f - Peso normal%n", imc);
        }
        case double i when i <= 29.9 -> {
            System.out.printf("IMC: %.2f - Levemente acima do peso%n", imc);
        }
        case double i when i <= 34.9 -> {
            System.out.printf("IMC: %.2f - Obesidade Grau I%n", imc);
        }
        case double i when i < 39.9 -> {
            System.out.printf("IMC: %.2f - Obesidade Grau II (Severa)%n", imc);
        }
        default -> {
            System.out.printf("IMC: %.2f - Obesidade Grau III (Mórbida)%n", imc);
        }
    }


    //TIP <b>Como fazer antes do Java 26</b><br>
    System.out.println("ANTES DO JAVA 26, usando IF");
    if (imc <= 18.5) {
        System.out.printf("IMC: %.2f - Abaixo do peso%n", imc);
    } else if (imc <= 24.9) {
        System.out.printf("IMC: %.2f - Peso normal%n", imc);
    } else if (imc <= 29.9) {
        System.out.printf("IMC: %.2f - Levemente acima do peso%n", imc);
    } else if (imc <= 34.9) {
        System.out.printf("IMC: %.2f - Obesidade Grau I%n", imc);
    } else if (imc <= 39.9) {
        System.out.printf("IMC: %.2f - Obesidade Grau II (Severa)%n", imc);
    } else {
        System.out.printf("IMC: %.2f - Obesidade Grau III (Mórbida)%n", imc);
    }

    //TIP <b>Código refeito pelo IntelliJ a partir do IF acima</b><br>
    System.out.println("Switch gerado pelo IntelliJ");
    switch (imc) {
        case double v when v <= 18.5 -> System.out.printf("IMC: %.2f - Abaixo do peso%n", imc);
        case double v when v <= 24.9 -> System.out.printf("IMC: %.2f - Peso normal%n", imc);
        case double v when v <= 29.9 -> System.out.printf("IMC: %.2f - Levemente acima do peso%n", imc);
        case double v when v <= 34.9 -> System.out.printf("IMC: %.2f - Obesidade Grau I%n", imc);
        case double v when v <= 39.9 -> System.out.printf("IMC: %.2f - Obesidade Grau II (Severa)%n", imc);
        default -> System.out.printf("IMC: %.2f - Obesidade Grau III (Mórbida)%n", imc);
    }
    System.out.println("Fim exercício 2");


    //TIP Exercício 3
    System.out.println("%n===== Gerador de números impáres e páres =====");
    System.out.print("Primeiro número: ");
    var nr1 = scanner.nextInt();
    boolean cont = true;
    var nr2 = 0;
    while (cont) {
        System.out.print("Segundo número: ");
        nr2 = scanner.nextInt();
        if (nr2 <= nr1){
            System.out.println("Segundo número deve ser MAIOR que o primeiro: ");
        } else {
            cont = false;
        }
    }
    System.out.println("Deseja exibir os Impares ou Pares (i/p)");
    var tipo = scanner.next();
    switch (tipo){
        case "i": {
            System.out.println("Os Impares são:");
            for (int i = nr2; i>=nr1; i--){
                if (i % 2 == 0) {
                    continue;
                }
                else {
                    System.out.printf("%s, ", i);
                }
            }
        break;
        }
        case "p": {
            System.out.println("Os Parers são:");
            for (int i = nr2; i>=nr1; i--){
                if (i % 2 == 0) {
                    System.out.printf("%s, ", i);
                }
                else {
                    continue;
                }
            }
            break;
        }
        default:{
            System.out.println("Tipo inválido, escolha 'I' ou 'P':");
            break;
        }
    }

    //TIP Exercício 4
    System.out.println("%n===== Continua enquanto a divisão vor exata  =====");
    System.out.print("Divisor: ");
    var divisor = scanner.nextInt();
    while (true){
        System.out.print("Dividendo: ");
        var dividendo = scanner.nextInt();
        if (dividendo < divisor) {
            System.out.printf("Informe um número maior que %s", divisor);
            continue;
        }
        var result = dividendo % divisor;
        if (result == 0) System.out.println("Divisão exata");
        if (result != 0) {
            System.out.println("Divisão teve restante, até mais");
            break;
        }
    }
}
