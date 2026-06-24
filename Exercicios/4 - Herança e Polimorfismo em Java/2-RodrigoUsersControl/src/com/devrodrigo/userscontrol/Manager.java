package com.devrodrigo.userscontrol;

public class Manager extends User{
    public Manager(String name, String email, String password, boolean isAdmin) {
        super(name, email, password, isAdmin);
    }

    // relatório financeiro
    public void financialReport(){
        System.out.println("✅ Tivemos este mês 190 milhões de reais de entrada e 180 mil reais de saída");
    }

    // relatório financeiro
    public void salesReport(){
        System.out.println("✅ Tivemos este mês 300 vendas tendo um faturamento bruto de 190 milhões de reais");
    }
}
