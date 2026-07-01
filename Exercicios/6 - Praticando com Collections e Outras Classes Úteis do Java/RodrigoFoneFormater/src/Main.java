import com.devrodrigo.phone.PhoneFormater;
import com.devrodrigo.phone.PhoneResponse;

Scanner scanner = new Scanner(System.in);

void main() {

    System.out.println("==============================");
    System.out.println("========Rodrigo Calc==========");
    System.out.printf ("==============================%n%n");

    String number = "";
    while (true){
        System.out.printf("DDD + telefone (ZERO para sair): %s", number);
        number = scanner.nextLine();
        if (number.equals("0")) System.exit(0);

        PhoneResponse phoneResponse = PhoneFormater.formatPhone(number);
        if (!phoneResponse.success()) number = phoneResponse.formattedNumber();

        System.out.printf("%s%n", phoneResponse);
    }





}
