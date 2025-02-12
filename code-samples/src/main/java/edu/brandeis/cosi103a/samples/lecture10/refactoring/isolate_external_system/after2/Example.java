package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.after2;

import edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.DatabaseClient;

// We've encapsulated the database interaction in a separate class called DataStore.
// This makes users of DataStore even more testable, because the interface to DataStore
// is smaller and simpler, which makes it easier to mock or fake.
//
// One downside of this approach is that the DataStore class now holds logic that 
// may not be very cohesive, especially if the database holds many different types of data.
class DataStore {
    private DatabaseClient dbClient;
    private String dbUrl;

    public DataStore(DatabaseClient dbClient, String dbUrl) {
        this.dbClient = dbClient;
        this.dbUrl = dbUrl;
    }

    public void addUser(String name, int age, String address) {
        dbClient.connect(dbUrl);
        dbClient.query("INSERT INTO users (name, age, address) VALUES (?, ?, ?)", new Object[] { name, age, address });
        dbClient.close();
    }

    public void updateAddress(String name, String newAddress) {
        dbClient.connect(dbUrl);
        dbClient.query("UPDATE users SET address = ? WHERE name = ?", new Object[] { newAddress, name });
        dbClient.close();
    }

    public void deleteUser(String name) {
        dbClient.connect(dbUrl);
        dbClient.query("DELETE FROM users WHERE name = ?", new Object[] { name });
        dbClient.close();
    }

    public void addPurchase(String user, String item, int quantity) {
        dbClient.connect(dbUrl);
        dbClient.query("INSERT INTO purchases (user, item, quantity) VALUES (?, ?, ?)", new Object[] { user, item, quantity });
        dbClient.close();
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
