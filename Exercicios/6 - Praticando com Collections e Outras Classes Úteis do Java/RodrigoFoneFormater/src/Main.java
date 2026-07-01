Scanner scanner = new Scanner(System.in);

void main() {

    System.out.println("==============================");
    System.out.println("========Rodrigo Calc==========");
    System.out.printf ("==============================%n%n");

    System.out.print("Digite os números separados por virgula (ex: 1,2,3,4,5): ");
    // aceita usuário digitar espaço, mas remove este espaço antes de gerar o array.
    var numbers = scanner.nextLine().replace(" ", "");

}
