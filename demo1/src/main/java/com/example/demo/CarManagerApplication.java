package com.example.demo;
// класс отвечает за запуск приложения
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class CarManagerApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(CarManagerApplication.class,args);
    }
}
