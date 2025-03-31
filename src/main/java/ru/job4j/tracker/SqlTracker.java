package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement pS = connection.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?) RETURNING id")) {
            pS.setString(1, item.getName());
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            pS.setTimestamp(2, timestampFromLDT);

            ResultSet rS = pS.executeQuery();
            if (rS.next()) {
                item.setId(rS.getInt("id"));
                return item;
            }
            return null;
        }
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        try (PreparedStatement pS = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            pS.setString(1, item.getName());
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            pS.setTimestamp(2, timestampFromLDT);
            pS.setInt(3, id);

            return pS.executeUpdate() > 0;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement pS = connection.prepareStatement(
                "DELETE FROM items WHERE id = ?")) {
            pS.setInt(1, id);

            pS.executeUpdate();
        }
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pS = connection.prepareStatement("SELECT id, name, created FROM items")) {

            ResultSet rS = pS.executeQuery();
            while (rS.next()) {
                items.add(createItemFromResultSet(rS));
            }
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pS = connection.prepareStatement(
                "SELECT id, name, created FROM items WHERE name = ?")) {
            pS.setString(1, key);

            ResultSet rS = pS.executeQuery();
            while (rS.next()) {
                items.add(createItemFromResultSet(rS));
            }
        }
        return items;
    }

    @Override
    public Item findById(int id) throws SQLException {
        try (PreparedStatement pS = connection.prepareStatement(
                "SELECT id, name, created FROM items WHERE id = ?")) {
            pS.setInt(1, id);

            ResultSet rS = pS.executeQuery();
            if (rS.next()) {
                return createItemFromResultSet(rS);
            }
        }
        return null;
    }

    private Item createItemFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Timestamp timestamp = rs.getTimestamp("created");
        LocalDateTime created = timestamp.toLocalDateTime();
        return new Item(id, name, created);
    }
}