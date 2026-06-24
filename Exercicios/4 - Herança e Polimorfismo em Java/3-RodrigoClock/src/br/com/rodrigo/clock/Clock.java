package br.com.rodrigo.clock;

public sealed abstract class Clock permits BRClock, USClock {

    protected int hour;
    protected int minute;
    protected int second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 24){
            this.hour = 0;
            return;
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 60){
            this.minute = 0;
            return;
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second >= 60){
            this.second = 0;
            return;
        }
        this.second = second;
    }

    private String format(int value){
        if (value <= 9)  return "0"+value;
        return String.valueOf(value);
    }

    public String getTime(){
        return format(hour)+":"+format(minute)+":"+format(second);
    }

    // Deixando a cargo das classes filhas.
    abstract Clock convert(Clock clock);
}
