package br.com.rodrigo.ticket;

public class FamilyTicket extends Ticket {

    private int numberMembers;
    private double priceBase;
//    public FamilyTicket(int numberMembers) {
//        this.numberMembers = numberMembers;
//    }

    @Override
    public void setValue(Double value) {
        if (this.numberMembers >=3){
            // aplica 5% de desconto
            this.value = value * 0.95;
            return;
        }
        System.out.println("Necessário 3 pessoas ou mais para comprar ingresso do tipo família.");
    }

    public FamilyTicket newFamilyTicketFromTicket(Ticket ticket, int numberMembers){
        this.numberMembers = numberMembers;
        setValue(ticket.value);
        this.movieName = ticket.getMovieName();
        this.dubbedOrSubtitled = ticket.getDubbedOrSubtitled();
        this.priceBase = ticket.value;
        return this;
    }

    @Override
    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Meia: %s, Tipo: %s, nr membros: %s %n",
                this.getMovieName(), this.priceBase, this.getValue(), this.dubbedOrSubtitled, this.numberMembers);
    }
}
