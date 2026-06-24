package br.com.rodrigo.ticket;

public class HalfTicket extends Ticket{

    public HalfTicket(double value, String movieName, String dubbedOrSubtitled) {
        super(value, movieName, dubbedOrSubtitled);
    }

    // criar novo obj a partir da classe Ticket
    public static HalfTicket fromTicket(Ticket ticket) {
        return new HalfTicket(
                ticket.getValue(),
                ticket.getMovieName(),
                ticket.getDubbedOrSubtitled()
        );
    }

    @Override
    public double getRealPrice() {
        return value/2;
    }

    @Override
    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Meia: %s, Tipo: %s %n",
                this.getMovieName(), this.getValue(), this.getRealPrice(), this.dubbedOrSubtitled);
    }
}
