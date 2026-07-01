import com.devrodrigo.phone.PhoneFormater;
import com.devrodrigo.phone.PhoneResponse;

Scanner scanner = new Scanner(System.in);

void main() {

    System.out.println("================================================");
    System.out.println("========Rodrigo Formatador de Telefone==========");
    System.out.printf ("================================================%n%n");

    while (true){
        System.out.print("DDD + telefone (ZERO para sair): ");
        String number = scanner.nextLine();
        if (number.equals("0")) System.exit(0);

        PhoneResponse phoneResponse = PhoneFormater.formatPhone(number);

        if (!phoneResponse.success()) {
            System.out.printf("❌ %s%n%n", phoneResponse.message());
            continue;
        }
        System.out.println("\n✅ Telefone processado com sucesso!");
        System.out.printf("Resultado estruturado (JSON):%n%s%n%n", phoneResponse.toJson());
    }
}
