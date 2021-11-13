package ru.ibs.hwdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.repo.CarRepository;

import java.security.SecureRandom;

@SpringBootApplication
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class,args);
    }
}
