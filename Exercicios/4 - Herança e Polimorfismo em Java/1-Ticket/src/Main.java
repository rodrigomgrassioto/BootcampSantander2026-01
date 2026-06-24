import br.com.rodrigo.ticket.FamilyTicket;
import br.com.rodrigo.ticket.HalfTicket;
import br.com.rodrigo.ticket.Ticket;

public  class Main{
    public static void main(String[] args){

        Ticket ingressoGeral = new Ticket(25,"Era uma vez", "Dublado");
        HalfTicket meiaEntrada = new HalfTicket().newHalfTicketFromTicket(ingressoGeral);
        FamilyTicket entradaFamilia = new FamilyTicket().newFamilyTicketFromTicket(ingressoGeral,8);

//        System.out.println(ingressoGeral.getMovieName());
//        System.out.println(meiaEntrada.getMovieName());
//        System.out.println(entradaFamilia.getMovieName());
        ingressoGeral.infos();
        meiaEntrada.infos();
        entradaFamilia.infos();

    }
}
