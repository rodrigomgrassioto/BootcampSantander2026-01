package br.com.rodrigo.ticket;

public class FamilyTicket extends Ticket {

    private int numberMembers;
    public FamilyTicket(double value, String movieName, String dubbedOrSubtitled, int numberMembers) {
        super(value, movieName, dubbedOrSubtitled);
        this.numberMembers = numberMembers;
    }

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
//        System.out.println("ao: "+this.numberMembers);
        double totalValue = super.getValue() * numberMembers;

        // Desconto se tiver mais q 3 membros
        if (numberMembers > 3) {
            totalValue *= 0.95; // 5% desconto
        }
        return totalValue;
    }

//    public FamilyTicket newFamilyTicketFromTicket(Ticket ticket, int numberMembers){
//        this.numberMembers = numberMembers;
//        setValue(ticket.value);
//        this.movieName = ticket.getMovieName();
//        this.dubbedOrSubtitled = ticket.getDubbedOrSubtitled();
//        return this;
//    }

    @Override
    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Família: %s (R$ unit: %s), Tipo: %s, nr ingressos: %s %n",
                this.getMovieName(), this.getValue(), this.getRealPrice(), this.getRealPrice()/this.numberMembers, this.dubbedOrSubtitled, this.numberMembers);
    }
}
