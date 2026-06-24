import com.devrodrigo.userscontrol.Attendant;
import com.devrodrigo.userscontrol.Manager;
import com.devrodrigo.userscontrol.Seller;

void main() {
    System.out.println("✅ GERENTE!");
    Manager gerente = new Manager("Rodrigo", "tst@devrodrigo.com.", "123");
    // teste com senha errada
    gerente.changePersonalData("Rodrigo Medeiros Grassioto", "falecom@devrodrigo.com", "555");
    // Atualizando dados
    gerente.changePersonalData("Rodrigo Medeiros Grassioto", "falecom@devrodrigo.com", "123");
    // teste com senha errada
    gerente.changePassword("568", "987");
    // trocando senha
    gerente.changePassword("123", "987");
    // relatório financeiro
    gerente.financialReport();
    // relatório de vendas
    gerente.salesReport();

    System.out.printf("%n%n✅ VENDEDOR!%n");
    Seller vendedor = new Seller("João da Silva", "joao@supervendas.com.br", "777", 8);
    vendedor.newSale();
    vendedor.consultSales();

    System.out.printf("%n%n✅ ATENDENTE!%n");
    Attendant atendente = new Attendant("Carlos Santos", "carlos@supervendas.com.br", "789", 1200);
    atendente.receivePayment(300);
    // com valore errado
    atendente.closeTheRegister(1200);
    // fechando caixa
    atendente.closeTheRegister(1500);
}
