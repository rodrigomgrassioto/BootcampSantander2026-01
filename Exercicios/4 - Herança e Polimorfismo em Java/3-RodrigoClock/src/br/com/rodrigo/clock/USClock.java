package br.com.rodrigo.clock;

public class USClock extends Clock{

    private String periodIndicator;

    public void setHour(int hour) {
        this.periodIndicator= "AM";
        if (hour >= 13 && hour <= 23){
            this.periodIndicator= "PM";
            this.hour = hour - 12;
            return;
        }
        this.hour = hour;
    }

    @Override
    public Clock convert(Clock clock) {
        return null;
    }
}
