package edu.brandeis.cosi103a.samples.lecture12.spring.jsonrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* To test: 
  curl -X POST "http://localhost:8080/api/greet" \
     -H "Content-Type: application/json" \
     -d '{"name": "Alice"}'
 */

@SpringBootApplication // Enables component scanning and auto-configuration
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
