package com.reto5;

import com.tablas.Pelicula;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicAplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAplication.class, args);
        Pelicula n = new Pelicula();
        System.out.println(n.getPeliResumen());
    }
}
