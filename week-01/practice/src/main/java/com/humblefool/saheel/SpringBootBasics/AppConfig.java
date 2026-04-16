package com.humblefool.saheel.SpringBootBasics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// THE PROGRAM WILL RUN WITHOUT THIS APP CONFIG TOO, ITS HERE JUST TO TAKE MORE CONTROL.
@Configuration
public class AppConfig {
    @Bean
    PaymentService paymentService() {
        return new PaymentService();
    }

}
