package com.devrodrigo.userscontrol;

public class Attendant extends User{
    // Classe Atendente que terá os seguintes atributos: Nome, Email, Senha,
    // Valor em caixa ** new
    // e um atributo que informa se ele é administrador, esse ultimo deve ser sempre falso.

    // Valor em caixa ** new
    private double cashValue;

    public Attendant(String name, String email, String password, double cashValue) {
        super(name, email, password, false);
        this.cashValue = cashValue;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    public void receivePayment(double value) {
        this.cashValue += value;
        System.out.printf("✅ Recebido R$ %.2f sucesso!%n", value);
    }

    public void closeTheRegister(double value){
        if (getCashValue() != value) {
            System.out.println("❌ Valores não conferem!");
            return;
        }
        System.out.printf("✅ Caixa fechado com sucesso no valor de R$ %.2f. %n", value);
    }

}
