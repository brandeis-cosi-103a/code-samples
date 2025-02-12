package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.after1;

import edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.DatabaseClient;

// We've made the UserManager and PurchaseTracker classes more testable 
// by injecting the DatabaseClient dependency.

class UserManager {
    private DatabaseClient dbClient;

    public UserManager(DatabaseClient dbClient) {
        this.dbClient = dbClient;
    }

    public void addUser(String name, int age, String address) {
        dbClient.connect("http://production-db.com:3306");
        dbClient.query("INSERT INTO users (name, age, address) VALUES (?, ?, ?)", new Object[] { name, age, address });
        dbClient.close();
    }

    public void updateAddress(String name, String newAddress) {
        dbClient.connect("http://production-db.com:3306");
        dbClient.query("UPDATE users SET address = ? WHERE name = ?", new Object[] { newAddress, name });
        dbClient.close();
    }

    public void deleteUser(String name) {
        dbClient.connect("http://production-db.com:3306");
        dbClient.query("DELETE FROM users WHERE name = ?", new Object[] { name });
        dbClient.close();
    }
}

class PurchaseTracker {
    private DatabaseClient dbClient;

    public PurchaseTracker() {
        this.dbClient = new DatabaseClient();
    }

    public void addPurchase(String user, String item, int quantity) {
        dbClient.connect("http://production-db.com:3306");
        dbClient.query("INSERT INTO purchases (user, item, quantity) VALUES (?, ?, ?)", new Object[] { user, item, quantity });
        dbClient.close();
    }
}