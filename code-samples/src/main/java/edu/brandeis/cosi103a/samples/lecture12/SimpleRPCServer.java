package edu.brandeis.cosi103a.samples.lecture12;

import java.io.*;
import java.net.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleRPCServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("RPC Server is running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Request {
    private String method;
    private int a;
    private int b;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            String requestLine = in.readLine();
            if (requestLine == null || !requestLine.startsWith("POST")) {
                sendResponse(out, 400, "Bad Request");
                return;
            }

            while (in.readLine() != null && !in.readLine().isEmpty()); // Read headers
            
            String requestBody = in.readLine(); // Read the JSON-like body
            String response = handleRequest(requestBody);
            sendResponse(out, 200, response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String handleRequest(String requestBody) {
        if (requestBody == null || !requestBody.startsWith("{")) {
            return "Invalid Request Format";
        }
        
        Request request = parseRequest(requestBody);
        String method = request.getMethod();
        String result;
        
        if ("add".equals(method)) {
            int a = request.getA();
            int b = request.getB();
            result = "" + (a + b);
        } else if ("multiply".equals(method)) {
            int a = request.getA();
            int b = request.getB();
            result = "" + (a * b);
        } else {
            result = "Unknown method";
        }
        
        return result;
    }

    private Request parseRequest(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(body, Request.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void sendResponse(PrintWriter out, int statusCode, String responseBody) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/plain");
        out.println("Content-Length: " + responseBody.length());
        out.println();
        out.println(responseBody);
    }
}
