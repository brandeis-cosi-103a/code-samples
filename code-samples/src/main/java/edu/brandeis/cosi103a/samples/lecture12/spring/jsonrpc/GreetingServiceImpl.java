package edu.brandeis.cosi103a.samples.lecture12.spring.jsonrpc;

import org.springframework.stereotype.Service;

@Service  // Spring-managed service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String getGreeting(String name) {
        return "Hello, " + (name != null ? name : "Spring Boot") + "!";
    }
}
