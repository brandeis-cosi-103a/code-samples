package edu.brandeis.cosi103a.samples.lecture12.spring.app;

import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring-managed component
public class GreetingServiceImpl implements GreetingService {
    @Override
    public void greet() {
        System.out.println("Hello, Spring Dependency Injection without @Autowired or @Bean!");
    }
}
