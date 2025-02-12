package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.after3;

import edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.DatabaseClient;

// Here we've made one last, small refactor to reduce duplication in the DataStore class.

class DataStore {
    private DatabaseClient dbClient;
    private String dbUrl;

    public DataStore(DatabaseClient dbClient, String dbUrl) {
        this.dbClient = dbClient;
        this.dbUrl = dbUrl;
    }

    private void executeQuery(String query, Object[] params) {
        dbClient.connect(dbUrl);
        dbClient.query(query, params);
        dbClient.close();
    }

    public void addUser(String name, int age, String address) {
        executeQuery("INSERT INTO users (name, age, address) VALUES (?, ?, ?)", new Object[] { name, age, address });
    }

    public void updateAddress(String name, String newAddress) {
        executeQuery("UPDATE users SET address = ? WHERE name = ?", new Object[] { newAddress, name });
    }

    public void deleteUser(String name) {
        executeQuery("DELETE FROM users WHERE name = ?", new Object[] { name });
    }

    public void addPurchase(String user, String item, int quantity) {
        executeQuery("INSERT INTO purchases (user, item, quantity) VALUES (?, ?, ?)", new Object[] { user, item, quantity });
    }
}

class UserManager {
    private DataStore dataStore;

    public UserManager(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void addUser(String name, int age, String address) {
        dataStore.addUser(name, age, address);
    }

    public void updateAddress(String name, String newAddress) {
        dataStore.updateAddress(name, newAddress);
    }

    public void deleteUser(String name) {
        dataStore.deleteUser(name);
    }
}

class PurchaseTracker {
    private DataStore dataStore;

    public PurchaseTracker(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void addPurchase(String user, String item, int quantity) {
        dataStore.addPurchase(user, item, quantity);
    }
}
