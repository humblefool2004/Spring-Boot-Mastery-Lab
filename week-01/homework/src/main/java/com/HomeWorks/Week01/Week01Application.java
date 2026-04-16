package com.HomeWorks.Week01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week01Application implements CommandLineRunner{

	public static void main(String[] args) {

        SpringApplication.run(Week01Application.class, args);
	}

    private final CakeBaker cakeBaker;

    Week01Application(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    @Override
    public void run(String... args) throws Exception {
        cakeBaker.bakeCake();
    }
}
