import javax.swing.*;

private final static Scanner scanner = new Scanner(System.in);
private static CheckingAccount account =null;
void main() {
    // Possibilidade de ter espeço nos valores digitados pelo usuário
    //scanner.useDelimiter("\\n");

    var option = -1;

    do {
        System.out.println("===============================");
        System.out.println("====+====Rodrigo Bankt=========");
        System.out.printf("===============================%n%n");

        System.out.println("Bem vindo!");
        System.out.println("Escolha uma das opções");
        System.out.println("1 - Nova conta conta corrente");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - consultar cheque especial disponível");
        System.out.println("4 - Depositar dinheiro");
        System.out.println("5 - Sacar dinheiro");
        System.out.println("6 - Pagar um boleto");
        System.out.println("7 - Verificar uso cheque especial");
        System.out.println("0 - Sair");

        // a linha abaixo gero erro de buffer teclado, por exemplo se digitar espaço ou SHIFT+ENTER.
//         option = scanner.nextInt();

        int opcao = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> newAccount();
            case 2-> getSaldo();
            case 3-> getChequeEspecial();
            case 4-> depositar();
            case 5-> sacar();
            case 6-> pagarBoleto();
            case 7-> verificarUsoChequeEspecial();
            case 0-> System.exit(0);
            default -> System.out.println("Opção inválida");
        }

    }while (true);
}

//TIP retira espaço, quebra de linha, letras  que o usuário tenha digitado e retorna somente valor
private static Number lerNumeroSeguro(String mensagem, String tipo) {
    while (true) {
        System.out.println(mensagem);
        String entrada = scanner.nextLine(); // Limpa e engole o buffer inteiro

        if (entrada.trim().isEmpty()) {
            System.out.println("⚠️ O campo não pode ficar em branco.");
            continue;
        }

        try {
            String textoLimpo = entrada.trim();

            // Usamos .equalsIgnoreCase para aceitar "int", "INT", "dou", "DOU" de forma segura
            if (tipo.equalsIgnoreCase("int")) {
                return Integer.parseInt(textoLimpo); // Retorna um número Inteiro
            } else if (tipo.equalsIgnoreCase("dou")) {
                return Double.parseDouble(textoLimpo); // Retorna um número Double
            }

        } catch (NumberFormatException e) {
            System.out.println("⚠️ Entrada inválida! Digite apenas números.");
        }
    }
}


private static void newAccount() {
    double initialBalance = 0.00;
    do {
        initialBalance = lerNumeroSeguro("Digite do depósito inicial.", "dou").doubleValue();
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
        depositoValor = lerNumeroSeguro("Valor do depóstio: (Zero para retornar).", "dou").doubleValue();
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

        saqueValor = lerNumeroSeguro("Valor do Saque: (Zero para retornar).", "dou").doubleValue();

        if (saqueValor > 0){
            System.out.printf("Verificando saldo para realizar o saque de R$ %.2f %n",saqueValor);
            account.withdraw(saqueValor);
            saqueValor = 0;
        }
    } while (saqueValor != 0);
}

private static void pagarBoleto() {
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    double valorBoleto = -1;
    do {
        System.out.println("Código do boleto:");
        String boletoCod = scanner.nextLine();
        if (boletoCod == null || boletoCod.trim().isEmpty()) {
            System.out.println("⚠️ O código do boleto não pode ficar em branco!");
            continue;
        }

        valorBoleto = lerNumeroSeguro("Valor a pagar: (Zero para retornar)", "dou").doubleValue();

        if (valorBoleto == 0) return;

        if (valorBoleto < 0) {
            System.out.println("⚠️ É preciso informar um valor maior que zero!");
            continue;
        }

        account.payBill(boletoCod, valorBoleto);
    } while (valorBoleto != 0);
}

private static void verificarUsoChequeEspecial() {
    if (account == null) {
        System.out.println("⚠️ Favor criar uma conta.");
        return;
    }
    account.checkOverdraftUsage();
}