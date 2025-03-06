package edu.brandeis.cosi103a.samples.lecture12.spring.app;

import org.springframework.stereotype.Component;

@Component // Automatically registered by Spring
public class GreetingController {
    
    private final GreetingService greetingService;

    // Constructor injection - Spring will automatically resolve this
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void sayHello() {
        greetingService.greet();
    }
}
