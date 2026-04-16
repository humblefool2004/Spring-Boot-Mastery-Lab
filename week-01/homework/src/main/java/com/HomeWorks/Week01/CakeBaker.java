package com.HomeWorks.Week01;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class CakeBaker{

    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, @Qualifier("chocolate") Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Baking Cake with "+ frosting.getFrostingType() + " and "+syrup.getSyrupType());
    }

    @PostConstruct
    void init(){
        System.out.println("Made the bean of the CakeBaker...");
    }
    @PreDestroy
    void destroy(){
        System.out.println("Removing the bean of the CakeBaker...");
    }
}
