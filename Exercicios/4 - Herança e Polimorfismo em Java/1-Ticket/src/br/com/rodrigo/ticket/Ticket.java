package br.com.rodrigo.ticket;

public class Ticket {
    protected double value;
    protected String movieName;
    protected String dubbedOrSubtitled;

    public Ticket(double value, String movieName, String dubbedOrSubtitled){
        this.value = value;
        this.movieName = movieName;
        this.dubbedOrSubtitled = dubbedOrSubtitled;
    }

    public Double getValue() {
        return value;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDubbedOrSubtitled() {
        return dubbedOrSubtitled;
    }

    public double getRealPrice() {
        return this.value;
    }

    public void infos(){
        System.out.printf("Título: %s, Valor inteiro: %s, Tipo: %s %n",
                this.getMovieName(), this.getValue(), this.dubbedOrSubtitled);
    }
}
