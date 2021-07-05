package service;


import database.Database;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private static final String TEST_DELETE_BOOK_QUERY = "DELETE from book WHERE id > ?";

    public void testDelete(Book book) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(TEST_DELETE_BOOK_QUERY)) {
            preparedStatement.setLong(1, book.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Book book = new Book();
    BookService bookService = new BookService();

    @org.junit.Test
    public void getAll() {
        assertNotNull(bookService.getAll());
    }

    @org.junit.Test
    public void save() {
        book.setContact_id(2000);
        book.setAddress_id(2000);
        bookService.save(book);
        assertNotNull(bookService.getAll());
    }

    @org.junit.Test
    public void update() {
        book.setAddress_id(1000);
        book.setContact_id(1000);
        book.setId(20);
        bookService.update(book);
        assertEquals(book.getId(), 20);
    }

    @org.junit.Test
    public void getAllContacts() {
        assertNotNull(bookService.getAllContacts());
    }

    @org.junit.After
    public void tearDown() throws Exception {
        book.setId(0);
        testDelete(book);
    }
}