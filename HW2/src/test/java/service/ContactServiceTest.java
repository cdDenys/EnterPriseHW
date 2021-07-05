package service;

import database.Database;
import entity.Address;
import entity.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private static final String TEST_DELETE_CONTACT_QUERY = "DELETE from contacts WHERE id > ?";
    Contact contact = new Contact();
    ContactService contactService = new ContactService();

    public void testDelete(Contact contact) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_CONTACT_QUERY)) {
            preparedStatement.setLong(1, contact.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        assertNotNull(contactService.getAll());
    }

    @Test
    void save() {
        contact.setId(2000);
        contact.setName("Denys");
        contact.setSurname("Suk");
        contactService.save(contact);
        assertEquals(contact.getName(), "Denys");
        assertEquals(contact.getSurname(), "Suk");
    }

    @Test
    void update() {
        contact.setId(2000);
        contact.setName("TEST");
        contact.setSurname("TEST");
        assertEquals(contact.getName(), "TEST");
        assertEquals(contact.getSurname(), "TEST");
    }

    @AfterEach
    void tearDown() {
        contact.setId(0);
        testDelete(contact);
    }
}