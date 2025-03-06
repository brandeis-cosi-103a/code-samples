package edu.brandeis.cosi103a.samples.lecture12.spring.jsonrpc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingController {
    
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET endpoint with query parameter
    @GetMapping("/greet")
    public GreetingResponse greet(@RequestParam(name = "name", required = false) String name) {
        return new GreetingResponse(greetingService.getGreeting(name));
    }

    // POST endpoint that accepts JSON and returns JSON
    @PostMapping("/greet")
    public GreetingResponse greetPost(@RequestBody GreetingRequest request) {
        return new GreetingResponse(greetingService.getGreeting(request.getName()));
    }
}

