package com.humblefool.saheel.SpringBootBasics.Impl;

import com.humblefool.saheel.SpringBootBasics.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

//@Primary
@Component
//@Qualifier("email")
@ConditionalOnProperty(name= "notification.type", havingValue = "email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email Sending: " + message);
    }
}
