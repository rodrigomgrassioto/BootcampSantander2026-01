package com.devrodrigo.userscontrol;

public class Seller extends User{
    // Classe Vendedor que terá os seguintes atributos: Nome, Email, Senha,
    // Quantidade de vendas **NEW
    // e um atributo que informa se ele é administrador, esse útimo deve ser sempre falso;

    private int numberOfSales;

    public Seller(String name, String email, String password, int numberOfSales) {
        super(name, email, password);
        this.numberOfSales = numberOfSales;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }
}
