package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int nextId = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(nextId++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] resArr = new Item[items.length];
        int size = 0;
        for (Item i : items) {
            if (i != null) {
                resArr[size] = i;
                size++;
            }
        }
        resArr = Arrays.copyOf(resArr, size);
        return resArr;
    }

    public Item[] findByName(String key) {
        Item[] resArr = new Item[items.length];
        int size = 0;
        for (Item i : items) {
            if (i != null && i.getName().equals(key)) {
                resArr[size] = i;
                size++;
            }
        }
        resArr = Arrays.copyOf(resArr, size);
        return resArr;
    }
}