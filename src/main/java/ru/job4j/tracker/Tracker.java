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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index].setId(id);
            items[index].setName(item.getName());
        }
        return index != -1;
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