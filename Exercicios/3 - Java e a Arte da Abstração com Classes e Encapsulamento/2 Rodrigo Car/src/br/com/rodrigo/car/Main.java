import br.com.rodrigo.car.Car;
import br.com.rodrigo.utils.ConsoleUtils;

void main() {
    Car car = new Car();
    var option = -1;

    do {
        System.out.println("===============================");
        System.out.println("====+====Rodrigo Car=========");
        System.out.printf("===============================%n%n");

        System.out.println("Bem vindo!");
        System.out.println("Escolha uma das opções");
        if (!car.getStatus()) {
            System.out.println("1 - Ligar");
            System.out.println("10 - Sair");
        }
        else {
            System.out.println("2 - Desligar");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Desacelerar");
            System.out.println("5 - Virar a esquerda");
            System.out.println("6 - Virar a direita");
            System.out.println("7 - Velocidade atual");
            System.out.println("8 - Subir marca");
            System.out.println("9 - Descer marca");
            if (car.isMoving()) {
                System.out.println("0 - Freada de emergência");
            }
        }

        int opcao = ConsoleUtils.lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> car.turnOn();
            case 2-> car.turnOff();
            case 3-> car.accelerate();
            case 4-> car.decelerate();
            case 5-> car.turnLeft();
            case 6-> car.turnRight();
            case 7-> car.getSpeed();
            case 8-> car.gearUp();
            case 9-> car.gearDown();
            case 0-> car.emergencyBreak();
            case 10-> {
                if (car.getStatus()) {
                    System.out.println("❗ Desligue o carro antes de sair");
                    continue;
                }
                System.exit(0);
            }
            default -> System.out.println("❌ Opção inválida");
        }

    }while (true);
}
