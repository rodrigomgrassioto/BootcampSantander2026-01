package com.devrodrigo.userscontrol;

public class Attendant extends User{
    // Classe Atendente que terá os seguintes atributos: Nome, Email, Senha,
    // Valor em caixa ** new
    // e um atributo que informa se ele é administrador, esse ultimo deve ser sempre falso.
    private double cashValue;

    public Attendant(String name, String email, String password, double cashValue) {
        super(name, email, password);
        this.cashValue = cashValue;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    // A classe Gerente deve ter os métodos Gerar relatório financeiro, Consultar vendas, Realizar
    // login, Realizar logff, alterar dados, alterar senha;
}
