package edu.brandeis.cosi103a.samples.lecture12.spring.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// To test: curl "http://localhost:8080/api/greet?name=Bert"

@SpringBootApplication // Enables component scanning and auto-configuration
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
