import br.com.rodrigo.clock.BRClock;
import br.com.rodrigo.clock.Clock;
import br.com.rodrigo.clock.USClock;

public class Main {

    public static void main(String[] args){
        Clock brClock = new BRClock();
        brClock.setSecond(0);
        brClock.setMinute(0);
        brClock.setHour(28);

        System.out.println(brClock.getTime());
        System.out.println(new USClock().convert(brClock).getTime());

    }
}
