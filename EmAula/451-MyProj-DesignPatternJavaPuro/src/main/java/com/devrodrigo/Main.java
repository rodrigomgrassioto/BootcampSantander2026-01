import com.devrodrigo.config_singleton.SystemConfig;
import com.devrodrigo.facade.NotificationFacade;
import java.util.Objects;

void main(){
        SystemConfig config = SystemConfig.getInstance();
        SystemConfig config2 = SystemConfig.getInstance();
        System.out.println(config); // sempre mesmo endereço de memória
        System.out.println(config2); // sempre mesmo endereço de memória
        System.out.println(config.getEnvironment());

        if (!Objects.equals(config.getEnvironment(), "PRODUCTION")){
            System.out.println("Fim teste desenvolvimento.");
            return;
        }
        var email = "felecom@devrodrigo.com";
        var cellPhone = "12345678901";

        NotificationFacade facade = new NotificationFacade();
        facade.sendWelcomeNotification(email, cellPhone);
}
