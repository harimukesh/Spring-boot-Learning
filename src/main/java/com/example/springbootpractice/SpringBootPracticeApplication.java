package com.example.springbootpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPracticeApplication {

    public static void main(String[] args) {

        ApplicationContext contextFactory =  SpringApplication.run(SpringBootPracticeApplication.class, args);

        Alien obj = (Alien) contextFactory.getBean("alien");
        obj.speak();





    }

}
