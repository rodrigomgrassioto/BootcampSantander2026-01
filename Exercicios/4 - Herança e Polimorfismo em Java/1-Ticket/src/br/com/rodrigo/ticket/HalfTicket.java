package br.com.rodrigo.ticket;

public class HalfTicket extends Ticket{

    public HalfTicket(double value, String movieName, String dubbedOrSubtitled) {
        super(value, movieName, dubbedOrSubtitled);
    }

//    public HalfTicket newHalfTicketFromTicket(Ticket ticket){
//        this.movieName = ticket.getMovieName();
//        this.dubbedOrSubtitled = ticket.getDubbedOrSubtitled();
//        this.priceBase = ticket.value;
//        setValue(ticket.value);
//        return this;
//    }

    @Override
    public double getRealPrice() {
        return value/2;
    }

    @Override
    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Meia: %s, Tipo: %s %n", this.getMovieName(), this.priceBase, this.getValue(), this.dubbedOrSubtitled);
    }
}
