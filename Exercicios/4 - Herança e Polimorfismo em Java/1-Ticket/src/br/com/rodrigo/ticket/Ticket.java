package br.com.rodrigo.ticket;

public class Ticket {
    private Double value;
    private String movieName;
    private String dubbedOrSubtitled;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDubbedOrSubtitled() {
        return dubbedOrSubtitled;
    }

    public void setDubbedOrSubtitled(String dubbedOrSubtitled) {
        this.dubbedOrSubtitled = dubbedOrSubtitled;
    }
}
