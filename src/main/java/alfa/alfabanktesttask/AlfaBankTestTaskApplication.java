package alfa.alfabanktesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfaBankTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaBankTestTaskApplication.class, args);
    }

}
