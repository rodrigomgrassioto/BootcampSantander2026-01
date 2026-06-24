package br.com.rodrigo.ticket;

public class FamilyTicket extends Ticket {

    private final int numberMembers;

    public FamilyTicket(double value, String movieName, String dubbedOrSubtitled, int numberMembers) {
        super(value, movieName, dubbedOrSubtitled);
        this.numberMembers = numberMembers;
    }

    // criar novo obj a partir da classe Ticket
    public static FamilyTicket fromTicket(Ticket ticket, int numberMembers) {
        return new FamilyTicket(
                ticket.getValue(),
                ticket.getMovieName(),
                ticket.getDubbedOrSubtitled(),
                numberMembers
        );
    }

    @Override
    public double getRealPrice() {
        double totalValue = super.getValue() * numberMembers;

        // Se mais q 3 membros
        if (numberMembers > 3) {
            totalValue *= 0.95; // 5% desconto
        }
        return totalValue;
    }

    @Override
    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Família: %s (R$ unit: %s), Tipo: %s, nr ingressos: %s %n",
                this.getMovieName(), this.getValue(), this.getRealPrice(), this.getRealPrice()/this.numberMembers,
                this.dubbedOrSubtitled, this.numberMembers);
    }
}
