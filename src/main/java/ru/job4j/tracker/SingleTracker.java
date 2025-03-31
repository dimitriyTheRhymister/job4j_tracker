package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class SingleTracker {
    private final Store memTracker = new MemTracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) throws SQLException {
        return memTracker.add(item);
    }

    public List<Item> findAll() throws SQLException {
        return memTracker.findAll();
    }

    public boolean replace(int id, Item item) throws SQLException {
        return memTracker.replace(id, item);
    }

    public void delete(int id) throws SQLException {
        memTracker.delete(id);
    }

    public Item findById(int id) throws SQLException {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String key) throws SQLException {
        return memTracker.findByName(key);
    }
}
