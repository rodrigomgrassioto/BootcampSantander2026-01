import javax.swing.*;

private final static Scanner scanner = new Scanner(System.in);
private static CheckingAccount account =null;
void main() {
    scanner.useDelimiter("\\n");

    var option = -1;

    do {
        System.out.println("===============================");
        System.out.println("====+====Rodrigo Bankt=========");
        System.out.println("===============================\n");

        System.out.println("Bem vindo!");
        System.out.println("Escolha uma das opções");
        System.out.println("1 - Nova conta conta corrente");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - consultar cheque especial");
        System.out.println("4 - Depositar dinheiro");
        System.out.println("5 - Sacar dinheiro");
        System.out.println("6 - Pagar um boleto");
        System.out.println("7 - Verificar uso cheque especial");
        System.out.println("0 - Sair");

        option = scanner.nextInt();

        switch (option) {
            case 1-> newAccount();
            case 2-> getSaldo();
            case 3-> getChequeEspecial();
            case 4-> depositar();
            case 5-> sacar();
//            case 6-> checkIfHasPetInMachine();
//            case 7-> setPetInPetMachine();
//            case 8-> petmachine.removePet();
//            case 9-> petmachine.washMachine();
            case 0-> System.exit(0);
            default -> System.out.println("Opção inválida");
        }

    }while (true);
}

private static void newAccount() {
    double initialBalance = 0.00;
    do {
        System.out.println("Digite do depósito inicial.");
        initialBalance = scanner.nextDouble();
        if (initialBalance <= 0){
            System.out.println("É necessário depósito para abrir uma conta");
        } else {
            account = new CheckingAccount(initialBalance);
        }
    } while (initialBalance <= 0);
}

private static void getSaldo() {
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    account.getBalance();
}

private static void getChequeEspecial(){
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    account.getOverdraftLimit();
}

public static void depositar(){
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    double depositoValor = 0;
    do {
        System.out.println("Valor do depóstio: (Zero para retornar).");
        depositoValor = scanner.nextDouble();
        if (depositoValor < 0){
            System.out.println("Valor do depóstio deve ter valor positivo.");
            depositoValor = 0;
        }
        if (depositoValor > 0){
            System.out.println("Conferindo valor a ser depositado.");
            account.deposit(depositoValor);
            depositoValor = 0;
        }
    } while (depositoValor != 0);
}

private static void sacar(){
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    double saqueValor = 0;
    do {
        System.out.println("Valor do Saque: (Zero para retornar).");
        saqueValor = scanner.nextDouble();
        if (saqueValor > 0){
            System.out.printf("Verificando saldo para realizar o saque de R$ %s \n",saqueValor);
            account.withdraw(saqueValor);
            saqueValor = 0;
        }
    } while (saqueValor != 0);
}