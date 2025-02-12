package edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.after1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.brandeis.cosi103a.samples.lecture10.refactoring.isolate_external_system.DatabaseClient;

public class ExampleTest {

    private DatabaseClient mockDbClient;
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        mockDbClient = mock(DatabaseClient.class);
        userManager = new UserManager(mockDbClient);
    }

    @Test
    public void testAddUser() {
        userManager.addUser("John Doe", 30, "123 Main St");

        verify(mockDbClient).connect("http://production-db.com:3306");
        verify(mockDbClient).query("INSERT INTO users (name, age, address) VALUES (?, ?, ?)", new Object[] { "John Doe", 30, "123 Main St" });
        verify(mockDbClient).close();
    }

    @Test
    public void testUpdateAddress() {
        userManager.updateAddress("John Doe", "456 Elm St");

        verify(mockDbClient).connect("http://production-db.com:3306");
        verify(mockDbClient).query("UPDATE users SET address = ? WHERE name = ?", new Object[] { "456 Elm St", "John Doe" });
        verify(mockDbClient).close();
    }

    @Test
    public void testDeleteUser() {
        userManager.deleteUser("John Doe");

        verify(mockDbClient).connect("http://production-db.com:3306");
        verify(mockDbClient).query("DELETE FROM users WHERE name = ?", new Object[] { "John Doe" });
        verify(mockDbClient).close();
    }
}
