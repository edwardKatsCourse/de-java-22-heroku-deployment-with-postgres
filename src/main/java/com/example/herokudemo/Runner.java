package com.example.herokudemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IService service;

    @Override
    public void run(String... args) throws Exception {
        service.print();
    }
}

interface IService {
    void print();
}

//@Service
@Profile("dev")
class IsraelDevService implements IService {
    @Override
    public void print() {
        System.out.println("Hello, Israel!");
    }
}

//@Service
@Profile("prod")
class GermanyProdService implements IService {
    @Override
    public void print() {
        System.out.println("Hello, Germany!");
    }
}