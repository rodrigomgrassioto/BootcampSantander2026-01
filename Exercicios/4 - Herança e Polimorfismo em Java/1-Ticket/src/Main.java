import br.com.rodrigo.ticket.FamilyTicket;
import br.com.rodrigo.ticket.HalfTicket;
import br.com.rodrigo.ticket.Ticket;

public  class Main{
    public static void main(String[] args){

        double precoBase = 25;
        String titulo = "Era uma vez";
        String dubOuLeg = "Dublado";
        int membrosFamilia = 4;

        Ticket ingressoGeral = new Ticket(precoBase,titulo, dubOuLeg);
        HalfTicket meiaEntrada = new HalfTicket(precoBase,titulo, dubOuLeg);
        FamilyTicket entradaFamilia = new FamilyTicket(precoBase,titulo, dubOuLeg, membrosFamilia);

//        System.out.println(ingressoGeral.getMovieName());
//        System.out.println(meiaEntrada.getMovieName());
//        System.out.println(entradaFamilia.getMovieName());
        ingressoGeral.infos();
        meiaEntrada.infos();
        entradaFamilia.infos();

        // Criando filhas a partir da classe pai
        precoBase = 35;
        titulo = "Era uma vez 3D";
        dubOuLeg = "Legendado";
        membrosFamilia = 5;

        Ticket ingressoGeral2 = new Ticket(precoBase,titulo, dubOuLeg);
        HalfTicket meiaEntrada2 = HalfTicket.fromTicket(ingressoGeral2);
        FamilyTicket entradaFamilia2 = FamilyTicket.fromTicket(ingressoGeral2, membrosFamilia);

        ingressoGeral2.infos();
        meiaEntrada2.infos();
        entradaFamilia2.infos();


    }
}
