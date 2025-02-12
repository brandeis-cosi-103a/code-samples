package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.after2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// The UserManager and PurchaseTracker classes in this example are trivial, and so these tests are 
// very uninteresting, but they demonstrate how any logic in these classes can now be easily
// isolated in a test by mocking DataStore.

class ExampleTest {
    private DataStore dataStore;
    private UserManager userManager;
    private PurchaseTracker purchaseTracker;

    @BeforeEach
    void setUp() {
        dataStore = mock(DataStore.class);
        userManager = new UserManager(dataStore);
        purchaseTracker = new PurchaseTracker(dataStore);
    }

    @Test
    void testAddUser() {
        userManager.addUser("John Doe", 30, "123 Main St");
        verify(dataStore).addUser("John Doe", 30, "123 Main St");
    }

    @Test
    void testUpdateAddress() {
        userManager.updateAddress("John Doe", "456 Elm St");
        verify(dataStore).updateAddress("John Doe", "456 Elm St");
    }

    @Test
    void testDeleteUser() {
        userManager.deleteUser("John Doe");
        verify(dataStore).deleteUser("John Doe");
    }

    @Test
    void testAddPurchase() {
        purchaseTracker.addPurchase("John Doe", "Laptop", 1);
        verify(dataStore).addPurchase("John Doe", "Laptop", 1);
    }
}
