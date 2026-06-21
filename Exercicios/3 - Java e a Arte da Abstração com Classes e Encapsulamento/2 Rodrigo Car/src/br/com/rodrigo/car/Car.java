package br.com.rodrigo.car;

public class Car {
    private boolean status;
    private int speed;
    private int gear;

    public Car() {
        this.status = true;
        this.speed = 120;
        this.gear = 6;
    }

    // ligar.
    public void turnOn(){
        if (this.status) {
            System.out.println("❗ Carro já está ligado.");
            return;
        }
        this.status = true;
        this.gear = 0;
        System.out.println("✅ Carro ligado com sucesso!");
    }
    // ligar.
    public void turnOff(){
        if (!this.status) {
            System.out.println("❗ Carro já está desligado.");
            return;
        }
        if(this.gear == 0 && this.speed == 0){
            this.status = false;
            System.out.println("✅ Carro desligado com sucesso!");
            return;
        }
        System.out.println("❌ Carro deve estar parado e em ponto morto para desligar!");
    }

    public void gearUp(){
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (this.gear >= 6) {
            System.out.printf("Já está na %sª marcha! %n", this.gear);
            return;
        }
        this.gear += 1;
        System.out.printf("✅ Subiu para a %sª marcha! E está a %s KM/h %n", this.gear, this.speed);
    }

    public void gearDown() {
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (this.gear <= 0) {
            System.out.printf("❌ Cambio está em neutro! %n");
            return;
        }
        this.gear -= 1;
        System.out.printf("✅ Desceu para a %sª marcha! E está a %s KM/h %n", this.gear, this.speed);
    }

    public void accelerate(){
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (this.gear == 0 ) {
            System.out.println("❌ Preserve o meio ambiente, não acelere o carro em ponto morto.");
            return;
        }
        if (this.speed < 20 && this.gear == 1) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 20 && this.speed < 40) && this.gear == 2) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 40 && this.speed < 60) && this.gear == 3) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 60 && this.speed < 80) && this.gear == 4) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 80 && this.speed < 100) && this.gear == 5) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 100 && this.speed < 120) && this.gear == 6) {
            this.speed += 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if (this.speed >= 120) {
            System.out.printf("❗ Já está na velocidade máxima de %s KM/H! %n", this.speed);
            return;
        }
        System.out.printf("❌ Você está a %s KM/H e está na %sª marcha.%n❗ Ajuste o cambio para acelerar %n", this.speed, this.gear);    }

    public void decelerate(){
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (this.gear == 0 ) {
            System.out.println("❌ Não manuseie o acelerador com o carro em ponto morto.");
            return;
        }
        if (this.speed <= 5) {
            this.speed = 0;
            this.gear = 0;
            System.out.println("✅ Carro parado, desengatado e acionado freio de estacionamento com sucesso!");
            return;
        }

        if (this.speed <= 20 && this.gear == 1) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 20 && this.speed <= 40) && this.gear == 2) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 40 && this.speed <= 60) && this.gear == 3) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 60 && this.speed <= 80) && this.gear == 4) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 80 && this.speed <= 100) && this.gear == 5) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 100 && this.speed <= 120) && this.gear == 6) {
            this.speed -= 5;
            System.out.printf("✅ Velocidade foi para %s KM/H, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        System.out.printf("❌ Você está a %s KM/H e está na %sª marcha.%n❗ Ajuste o cambio para desacelerar %n", this.speed, this.gear);
    }

    public void turnLeft() {
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        System.out.printf("❗ Virando esquerda Velocidade atual é de %s KM/h! %n", this.speed);
    }

    public void turnRight() {
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        System.out.printf("❗ Virando direita Velocidade atual é de %s KM/h! %n", this.speed);
    }
    public void emergencyBreak(){
        if (!this.status || this.speed == 0 ) {
            System.out.println("❌ Carro já está parado.");
            return;
        }
        this.speed = 0;
        this.gear = 0;
        System.out.println("✅ Carro parado, desengatado e acionado freio de estacionamento com sucesso!");
    }

    public void getSpeed(){
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
        }
        System.out.printf("❗ Velocidade atual é de %s KM/h! %n", this.speed);
    }

    public boolean isMoving(){
        return this.speed > 0;
    }

    public boolean getStatus(){
        return this.status;
    }
}
