package edu.brandeis.cosi103a.samples.lecture12.spring.jsonrpc;

public class GreetingRequest {
    private String name;

    // Default constructor for JSON deserialization
    public GreetingRequest() {}

    public GreetingRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
