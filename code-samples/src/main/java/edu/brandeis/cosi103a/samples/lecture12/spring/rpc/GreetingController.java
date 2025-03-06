package edu.brandeis.cosi103a.samples.lecture12.spring.rpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Marks this class as a REST API controller
@RequestMapping("/api") // Base path for API routes
public class GreetingController {
    
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet") // Handles GET requests to /api/greet
    public String greet(@RequestParam(name = "name", required = false) String name) {
        return greetingService.getGreeting(name);
    }
}

