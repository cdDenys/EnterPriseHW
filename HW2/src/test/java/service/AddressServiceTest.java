package service;

import database.Database;
import entity.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {
    private static final String TEST_DELETE_ADDRESS_QUERY = "DELETE from addresses WHERE id > ?";
    Address address = new Address();
    AddressService addressService = new AddressService();

    public void testDelete(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_ADDRESS_QUERY)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        assertNotNull(addressService.getAll());
    }

    @Test
    void save() {
        address.setId(200);
        address.setCity("New-York");
        address.setStreet("Test street");
        address.setHouseNumber(1111);
        addressService.save(address);
        assertNotNull(addressService.getAll());
        assertEquals(address.getId(), 200);
        assertEquals(address.getCity(), "New-York");
        assertEquals(address.getStreet(), "Test street");
        assertEquals(address.getHouseNumber(), 1111);
    }

    @Test
    void update() {
        address.setId(2);
        address.setCity("TEST");
        address.setStreet("TEST");
        address.setHouseNumber(2222);
        addressService.update(address);
        assertEquals(address.getHouseNumber(), 2222);
        assertEquals(address.getStreet(), "TEST");
        assertEquals(address.getCity(), "TEST");
    }

    @AfterEach
    void tearDown() {
        address.setId(0);
        testDelete(address);
    }
}