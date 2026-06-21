package br.com.rodrigo.car;

public class Car {
    private boolean status;
    private int speed;
    private int gear;
    private int incrementDecrementSpeed = 1;

    public Car() {
        this.status = false;
        this.speed = 0;
        this.gear = 0;
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
        System.out.printf("✅ Subiu para a %sª marcha! E está a %s km/h %n", this.gear, this.speed);
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
        // FREIO MOTOR
        if (this.gear == 5 && this.speed > 100) {
            System.out.println("❗Freio motor foi ativado, " +
                    "para uma direção suave reduza a velocidade antes de reduzir a marcha");
            this.speed = 100;
        } else if (this.gear == 4 && this.speed > 80) {
            System.out.println("❗Freio motor foi ativado, " +
                    "para uma direção suave reduza a velocidade antes de reduzir a marcha");
            this.speed = 80;
        } else if (this.gear == 3 && this.speed > 60) {
            System.out.println("❗Freio motor foi ativado, " +
                    "para uma direção suave reduza a velocidade antes de reduzir a marcha");
            this.speed = 60;
        } else if (this.gear == 2 && this.speed > 40) {
            System.out.println("❗Freio motor foi ativado, " +
                    "para uma direção suave reduza a velocidade antes de reduzir a marcha");
            this.speed = 40;
        } else if (this.gear == 1 && this.speed > 20) {
            System.out.println("❗Freio motor foi ativado, " +
                    "para uma direção suave reduza a velocidade antes de reduzir a marcha");
            this.speed = 20;
        } else if (this.gear == 0 && this.speed > 0) {
            System.out.println("❗Câmbio em ponto morto com o carro em movimento! O carro está na banguela.");
        }
        System.out.printf("✅ Desceu para a %sª marcha! E está a %s km/h %n", this.gear, this.speed);
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
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 20 && this.speed < 40) && this.gear == 2) {
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 40 && this.speed < 60) && this.gear == 3) {
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 60 && this.speed < 80) && this.gear == 4) {
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 80 && this.speed < 100) && this.gear == 5) {
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed >= 100 && this.speed < 120) && this.gear == 6) {
            this.speed += this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if (this.speed >= 120) {
            System.out.printf("❗ Já está na velocidade máxima de %s km/h! %n", this.speed);
            return;
        }
        System.out.printf("❌ Você está a %s km/h e está na %sª marcha.%n❗ Ajuste o cambio para acelerar %n", this.speed, this.gear);    }

    public void decelerate(){
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (this.gear == 0 ) {
            System.out.println("❌ Não manuseie o acelerador com o carro em ponto morto.");
            return;
        }
        if (this.speed == 0) {
            System.out.println("❗ O carro já parado.");
            return;
        }
        if (this.speed <= this.incrementDecrementSpeed) {
            this.speed = 0;
            this.gear = 0;
            System.out.println("✅ Carro parado, desengatado e acionado freio de estacionamento com sucesso!");
            return;
        }

        if (this.speed <= 20 && this.gear == 1) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 20 && this.speed <= 40) && this.gear == 2) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 40 && this.speed <= 60) && this.gear == 3) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 60 && this.speed <= 80) && this.gear == 4) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 80 && this.speed <= 100) && this.gear == 5) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        if ((this.speed > 100 && this.speed <= 120) && this.gear == 6) {
            this.speed -= this.incrementDecrementSpeed;
            System.out.printf("✅ Velocidade foi para %s km/h, na %sª marcha! %n", this.speed, this.gear);
            return;
        }
        System.out.printf("❌ Você está a %s km/h e está na %sª marcha.%n❗ Ajuste o cambio para desacelerar %n", this.speed, this.gear);
    }

    public void turnLeft() {
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (!this.isMoving() || this.speed > 40){
            System.out.println("❌ Para virar velocidade deve estar entre 1 e 40 km/h.");
            return;
        }
        System.out.printf("✅ Virando esquerda.%n✅ Velocidade atual é de %s km/h! e está na %sª marcha %n", this.speed, this.gear);
    }

    public void turnRight() {
        if (!this.status) {
            System.out.println("❌ Carro desligado.");
            return;
        }
        if (!this.isMoving() || this.speed > 40){
            System.out.println("❌ Para virar velocidade deve estar entre 1 e 40 km/h.");
            return;
        }
        System.out.printf("✅ Virando direita.%n✅ Velocidade atual é de %s km/h! e está na %sª marcha %n", this.speed, this.gear);
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
        System.out.printf("✅ Velocidade atual é de %s km/h e está na %sª marcha! %n", this.speed, this.gear);
    }

    public boolean isMoving(){
        return this.speed > 0;
    }

    public boolean getStatus(){
        return this.status;
    }
}
