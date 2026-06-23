package br.com.rodrigo.clock;

public non-sealed class BRClock extends Clock {

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.second;
        this.minute = clock.minute;
        switch (clock){
            case USClock usClock ->  this.hour = (usClock.getPeriodIndicator().equals("PM")) ?
                    usClock.getHour() + 12 :
                    usClock.getHour();
            case BRClock brClock -> this.hour = brClock.getHour();
        }
        return this;

    }
}
