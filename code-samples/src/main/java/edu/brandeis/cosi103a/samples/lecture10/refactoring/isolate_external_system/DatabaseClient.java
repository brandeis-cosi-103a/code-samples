package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system;

public class DatabaseClient {
    public void connect(String address) {
        System.out.println("Connecting to database...");
    }

    public void query(String sql, Object[] params) {
        System.out.println("Executing query: " + sql + " with params: " + java.util.Arrays.toString(params));
    }

    public void close() {
        System.out.println("Closing connection...");
    }
}
