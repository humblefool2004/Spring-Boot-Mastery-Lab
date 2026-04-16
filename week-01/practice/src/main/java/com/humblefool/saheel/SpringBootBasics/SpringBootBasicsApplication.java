package com.humblefool.saheel.SpringBootBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBasicsApplication implements CommandLineRunner {

    //@Autowired // no need for constructor DI
    PaymentService paymentServiceObj;

   // @Autowired//no need for constructor Dependency injection
    NotificationService notificationServiceObj;

    //constructor dependency injection
    //public SpringBootBasicsApplication(@Qualifier("email") NotificationService notificationServiceObj, PaymentService paymentServiceObj) {
     public SpringBootBasicsApplication(NotificationService notificationServiceObj, PaymentService paymentServiceObj) {
        this.notificationServiceObj = notificationServiceObj;
        this.paymentServiceObj = paymentServiceObj;
    }

	public static void main (String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        paymentServiceObj.pay();
        notificationServiceObj.send("Helllo !!!");
    }
}
