package br.com.rodrigo.car;

public class Car {
    private boolean status;
    private int speed;
    private int gear;

    public Car() {
        this.status = false;

    }

    // ligar ou desligar
    public void onOff(){
        this.status = !this.status;
        this.gear = 0;
    }


    public void accelerate(){
        System.out.println("Acelerando !");
        this.speed += 5;
    }

    public void decelerate(){
        System.out.println("Diminuindo velocudade!");
        this.speed -= 5;
    }

    public void turnLeft(){
        System.out.println("Virando Esquerda!");
    }
    public void turnRight(){
        System.out.println("Virando Direita!");
    }

    public void gearUp(){


    }


    public int gearDown() {
        return speed;
    }
}
