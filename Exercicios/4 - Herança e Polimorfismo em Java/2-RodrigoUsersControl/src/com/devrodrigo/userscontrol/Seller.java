package com.devrodrigo.userscontrol;

public class Seller extends User{
    // Classe Vendedor que terá os seguintes atributos: Nome, Email, Senha,
    // Quantidade de vendas **NEW
    // e um atributo que informa se ele é administrador, esse útimo deve ser sempre falso;

    private int numberOfSales;

    public Seller(String name, String email, String password, int numberOfSales) {
        super(name, email, password, false);
        this.numberOfSales = numberOfSales;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    // Nova venda
    public void newSale(){
        this.numberOfSales += 1;
        System.out.println("✅ Venda realizada com sucesso!");
    }

    public void consultSales(){
        System.out.printf("%n%nℹ️ CONSULTA DE VENDAS!%n");
        System.out.println("ℹ️ Pedido 1 Pedro Grassioto");
        System.out.println("ℹ️ Pedido 2 Maria Rita");
        System.out.println("ℹ️ Pedido 3 Carla Thais");

        System.out.printf("ℹ️ Total de vendas no mês: %s. %n", getNumberOfSales());
    }




}
