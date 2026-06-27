import com.devrodrigo.messagessender.*;
import java.util.Scanner;
import static com.devrodrigo.utils.ConsoleUtils.lerNumeroSeguro;

Scanner scanner = new Scanner(System.in);
MessageSender messageSender;
String msg;
String msgTodos = "";

void main(){
    do {
        System.out.println("==++++++=================================");
        System.out.println("========Rodrigo Múltiplos envios=========");
        System.out.printf ("========++++++===========================%n%n");

        System.out.println("Bem vindo!");
        System.out.println("O que vamos fazer?");
        if (msg == null || msg.isBlank()) {
            System.out.println("1 - Escrever Mensagem");
        }
        if (msg != null && !msg.isBlank()) {

            System.out.println("Quer enviar a msg por qual meio?");
            System.out.println("2 - SMS");
            System.out.println("3 - E-Mail");
            System.out.println("4 - Facebook");
            System.out.println("5 - WhatsApp");
            System.out.println("6 - Todos");
            System.out.println("7 - Limpar mensagem");
        }
        System.out.println("0 - Sair");

        int opcao = lerNumeroSeguro("Escolha uma das opções:", "int").intValue();

        switch (opcao) {
            case 1-> msgWrite() ;
            case 2-> messageSender = new Sms();
            case 3-> messageSender = (txt) -> "Lamb: ✅ Enviado "+ txt +" via E-mail%n";
            case 4-> messageSender = new SocialMedia();
            case 5-> messageSender = new Whatsapp();
            case 6-> todos();
            case 7-> msg = null;
            case 0-> System.exit(0);
            default -> System.out.println("❌ Opção inválida");
        }
        if (messageSender != null){
            System.out.printf(messageSender.sendMessage(msg));
            messageSender = null;
        }

        if (msgTodos != null && !msgTodos.isEmpty()) {
            System.out.printf(msgTodos);
            msgTodos = "";
        }
    }while (true);
}
private void msgWrite(){
    System.out.println("Digite a mensagem:");
    msg = scanner.nextLine();
}

private void todos() {
    // Criamos uma lista com todos os serviços
    java.util.List<MessageSender> servicos = java.util.List.of(
            new Sms(), new Email(), new SocialMedia(), new Whatsapp()
    );

//    msgTodos = "";
    // Passamos a mesma mensagem como parâmetro para cada um deles
    for (MessageSender servico : servicos) {
        msgTodos += servico.sendMessage(msg);
    }
}

