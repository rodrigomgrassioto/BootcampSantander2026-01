package br.com.rodrigo.clock;

public non-sealed class USClock extends Clock{

    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidday(){
        this.periodIndicator = "PM";
    }
    public void setBeforeMidday(){
        this.periodIndicator = "AM";
    }

    public void setHour(int hour) {
        setBeforeMidday();
        if (hour >= 13 && hour <= 23){
            setAfterMidday();
            this.hour = hour - 12;
            return;
        } else if (hour >= 24) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
        this.hour = hour;
    }

    @Override
    public Clock convert(Clock clock) {

        switch (clock){
            case USClock usClock ->  this.hour = (usClock.getPeriodIndicator().equals("PM")) ?
                    usClock.getHour() + 12 :
                    usClock.getHour();
            case BRClock brClock -> {
                if ()
                this.hour = brClock.getHour() - 12
            };
        }
        return this;
    }
}
