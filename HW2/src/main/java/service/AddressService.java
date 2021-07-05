package service;

import database.Database;
import entity.Address;
import entity.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService {
    private static final String SELECT_ALL_ADDRESS_QUERY = "SELECT * FROM addresses";
    private static final String SAVE_ADDRESS_QUERY = "INSERT INTO addresses (city, street, house_number) VALUES (?,?,?)";
    private static final String UPDATE_ADDRESS_QUERY = "UPDATE addresses SET city = ?, street = ?, house_number = ? WHERE id = ?";
    private static final String DELETE_ADDRESS_QUERY = "DELETE from addresses WHERE id = ?";

    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ADDRESS_QUERY);
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHouseNumber(resultSet.getInt("house_number"));
                addresses.add(address);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public void save(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getHouseNumber());

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getHouseNumber());
            preparedStatement.setLong(4, address.getId());

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Address address) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_ADDRESS_QUERY)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
