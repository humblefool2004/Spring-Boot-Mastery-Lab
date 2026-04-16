package com.humblefool.saheel.SpringBootBasics;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    void beforeInit(){
        System.out.println("Before init...");
    }

    @PreDestroy
    void afterInit(){
        System.out.println("After init...");
    }
    //the above will run before the application shutdown

}
