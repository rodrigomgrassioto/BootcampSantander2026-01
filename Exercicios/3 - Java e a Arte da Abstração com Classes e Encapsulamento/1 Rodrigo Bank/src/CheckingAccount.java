public class CheckingAccount {
    // Saldo:
    private double balance;
    // Limite cheque especial disponível
    private double overdraftLimitAvailable;
    // Limite cheque especial
    private double specialLimit;

    public CheckingAccount(double initialBalance) {
        this.balance = initialBalance;
        if (initialBalance <= 500.00) {
            this.overdraftLimitAvailable = 50.00;
            this.specialLimit = this.overdraftLimitAvailable;
        } else {
            this.overdraftLimitAvailable = initialBalance * 0.50;
            this.specialLimit = this.overdraftLimitAvailable;
        }
        System.out.println("Conta Criada com sucesso!");
    }

    // pegar Saldos
    public void getBalance() {
        System.out.printf("Saldo pessoal: R$ %.2f %n", balance);
        System.out.printf("Limite total: R$ %.2f %n", specialLimit);
        if (specialLimit != overdraftLimitAvailable){
            double taxaUsoLimite = (specialLimit-overdraftLimitAvailable)*0.2;
            double valorQuitarLimite = (specialLimit-overdraftLimitAvailable) + taxaUsoLimite;

            System.out.printf("=============================================%n");
            System.out.printf("=========Está usando limite especial=========%n");
            System.out.printf("==============Segue informações==============%n");
            System.out.printf("=============================================%n%n");

            System.out.printf("Limite disponível: R$ %.2f %n", overdraftLimitAvailable);
            System.out.printf("Limite utilizado: R$ %.2f %n", (specialLimit-overdraftLimitAvailable));
            System.out.printf("Taxa de uso do limite: R$ %.2f %n", taxaUsoLimite);
            System.out.printf("Valor para quitar o Limite: R$ %.2f %n", valorQuitarLimite);
        } else {
            System.out.println("=========Não está usando o limite especial=========");
        }
            System.out.printf("%nTotal (Saldo + limite especial): R$ %.2f %n%n", (balance + overdraftLimitAvailable));
    }

    // Consultar saldo do limite
    public void getOverdraftLimit() {
        System.out.printf("Limite: R$ %.2f %n", overdraftLimitAvailable);
    }

    // Depositar
    public void deposit(double amount){
        // se tiver usando cheque especial, cobrar + taxa uso cheque especial 20%
        if (this.specialLimit > this.overdraftLimitAvailable) {
            double limitUsed = ((this.specialLimit - this.overdraftLimitAvailable) * 0.2) + (this.specialLimit - this.overdraftLimitAvailable) ;

            // se depósito for menor que o limite usado
            if(amount < limitUsed){
                // double valorParaDepNoLime = amount - (amount * 0.2);
                // a linha acima, se o cliente tiver um débito inicial de 76,68 (20% = 15,336 = Total 92,016) e pagar em 2x de 50 reais o saldo
                // final na conta corrente será de 5,98 e o correto é 7,98 (100 - 92,02)

                double valorParaDepNoLime = amount / 1.20;
                this.overdraftLimitAvailable += valorParaDepNoLime;
                System.out.println("Depósito realizado");
                System.out.println("Valores atualizados");
                getBalance();
            // se depósito for igual ao limite usado
            } else if (amount == limitUsed) {
                this.overdraftLimitAvailable = this.specialLimit;
                System.out.println("Depósito realizado");
                System.out.println("Valores atualizados");
                getBalance();
            // se depósito for maior ao limite usado
            } else {
                double creditoContaCorrente = amount -limitUsed;
                this.overdraftLimitAvailable = this.specialLimit;
                this.balance += creditoContaCorrente;
                System.out.println("Depósito realizado");
                System.out.println("Valores atualizados");
                getBalance();
            }
        // se não estiver usando o limite
        } else {
            this.balance += amount;
            System.out.println("Depósito realizado");
            System.out.println("Valores atualizados");
            getBalance();
        }

    }

    // SACAR - amount = valor do saque
    public void withdraw(double amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Retirado o valor: R$ %.2f %n", amount);
            System.out.println("Valores atualizados");
            getBalance();
        } else if ((balance + overdraftLimitAvailable) >= amount) {
            var retirarDoLimite =amount - balance;
            balance = 0;
            overdraftLimitAvailable -= retirarDoLimite;
            System.out.printf("Retirado o valor: R$ %.2f %n", amount);
            System.out.println("Valores atualizados");
            getBalance();
        } else {
            System.out.printf("Saldo insuficiente para sacar: R$ %.2f %n", amount);
        }
    }

    // Pagar boleto
    public void payBill(String cod, double amount){
        if (amount <= 0) {
            System.out.println("⚠️ Informe valor maior que zero.");
            return;
        }
        if (this.balance + this.overdraftLimitAvailable < amount) {
            System.out.printf("Saldo insuficiente para pagar: R$ %.2f %n", amount);
            return;
        }
        // se saldo pessoal for suficiente para pagar o boleto
        if (this.balance >= amount){
            this.balance -= amount;
            System.out.printf("Pago: %.2f, no boleto cód: %s %n", amount, cod);
            return;
        }
        // se necessário usar o limite especial
        double retirarLimite = amount - this.balance;
        this.balance = 0;
        this.overdraftLimitAvailable -= retirarLimite;
        System.out.printf("Pago: %.2f, no boleto cód: %s USANDO LIMITE ESPECIAL %n", amount, cod);
    }

    // Verificar uso do cheque especial
    public void checkOverdraftUsage(){
        double amountUsed = this.specialLimit - this.overdraftLimitAvailable;

        if (amountUsed > 0) {
            System.out.printf("Você está utilizando: R$ %.2f do seu Cheque Especial.%n", amountUsed);
        } else {
            System.out.println("Você não está utilizando o seu Cheque Especial.");
        }
    }
}
