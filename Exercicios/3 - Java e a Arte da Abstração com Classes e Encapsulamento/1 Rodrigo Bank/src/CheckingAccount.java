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
        System.out.printf("Saldo: %s\n", balance);
        System.out.printf("Limite: %s\n", overdraftLimitAvailable);
        System.out.printf("Total: %s\n", (balance + overdraftLimitAvailable));
    }

    // Consultar saldo do limite
    public void getOverdraftLimit() {
        System.out.printf("Limite: %s\n", overdraftLimitAvailable);
    }

    // Depositar
    public void deposit(double amount){
        // se tiver usando cheque especial, cobrar + taxa uso cheque especial 20%
        if (this.specialLimit > this.overdraftLimitAvailable) {
            double limitUsed = ((this.specialLimit - this.overdraftLimitAvailable) * 0.2) + (this.specialLimit - this.overdraftLimitAvailable) ;

            // se depósito for menor que o limite usado
            if(amount < limitUsed){
                double valorParaDepNoLime = amount - (amount * 0.2);
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
            System.out.printf("Retirado o valor: %s\n", amount);
            System.out.println("Valores atualizados");
            getBalance();
        } else if ((balance + overdraftLimitAvailable) >= amount) {
            var retirarDoLimite =amount - balance;
            balance = 0;
            overdraftLimitAvailable -= retirarDoLimite;
            System.out.printf("Retirado o valor: %s\n", amount);
            System.out.println("Valores atualizados");
            getBalance();
        } else {
            System.out.printf("Saldo insuficiente para sacar: %s\n", amount);
        }
    }
}
