
private final static PetMachine petmachine = new PetMachine();
private final static Scanner scanner = new Scanner(System.in);

void main() {
    scanner.useDelimiter("\\n");

    var option = -1;

    do {
        System.out.println("===============================");
        System.out.println("===Máquina de limpeza de pet===");
        System.out.println("===============================\n");

        System.out.println("Escolha uma das opções");
        System.out.println("1 - Dar banho");
        System.out.println("2 - Abastecer água");
        System.out.println("3 - Abastecer shampoo");
        System.out.println("4 - Verificar água");
        System.out.println("5 - Verificar shampoo");
        System.out.println("6 - Verificar se tem pet na máquina");
        System.out.println("7 - Colocar pet");
        System.out.println("8 - Retirar pet");
        System.out.println("9 - Limpar máquina");
        System.out.println("0 - Sair");

        option = scanner.nextInt();

        switch (option) {
            case 1-> petmachine.takeAShower();
            case 2-> petmachine.addWater();
            case 3-> petmachine.addShampoo();
            case 4-> verifyWater();
            case 5-> verifyShampoo();
            case 6-> checkIfHasPetInMachine();
            case 7-> setPetInPetMachine();
            case 8-> petmachine.removePet();
            case 9-> petmachine.washMachine();
            case 0-> System.exit(0);
            default -> System.out.println("Opção inválida");
        }

    }while (true);
}

private static void verifyShampoo() {
    var amount = petmachine.getShampoo();
    System.out.printf("Tem %s litros de shampoo\n", amount);
}
private static void verifyWater() {
    var amount = petmachine.getWater();
    System.out.printf("Tem %s litros de água\n", amount);
}

private static void checkIfHasPetInMachine() {
    var hasPet = petmachine.hasPet();
    System.out.println(hasPet ? "Tem pet na máquina" : "Máquina disponível.");
}

public static void setPetInPetMachine(){
    var name = "";
    while (name == null || name.isEmpty()){
        System.out.print("Nome do pet: ");
        name = scanner.next();
    }
    var pet = new Pet(name);
    petmachine.setPet(pet);
}
