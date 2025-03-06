package edu.brandeis.cosi103a.samples.lecture12.spring.jsonrpc;

public class GreetingResponse {
    private String message;

    public GreetingResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
