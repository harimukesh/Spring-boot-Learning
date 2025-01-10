package com.example.springbootpractice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Alien {

    @Autowired(required=false)
    ConditionalProperty conditionalProperty;

    Laptop laptop;

    @Autowired
    public Alien(Laptop laptop) {
        this.laptop = laptop;
    }

    public void speak() {
        laptop.specific();
    }

    @PostConstruct
    public void init() {
        System.out.println(Objects.isNull(conditionalProperty));  //false
    }
}
