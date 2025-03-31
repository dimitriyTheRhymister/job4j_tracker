package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemTrackerTest {
    @Test
    public void whenTestFindById() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = memTracker.add(bug);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        Item result = memTracker.findAll().get(0);
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        memTracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        memTracker.replace(id, updateItem);
        assertThat(memTracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        memTracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = memTracker.replace(1000, updateItem);
        assertThat(memTracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        Item item2 = new Item("Bug");
        Item item3 = new Item("Bug");
        Item item4 = new Item("Bug");
        memTracker.add(item);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.add(item4);
        memTracker.delete(1);
        List<Item> result = memTracker.findAll();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Bug");
        memTracker.add(item);
        memTracker.delete(1);
        List<Item> result = memTracker.findAll();
        assertThat(result.size()).isEqualTo(0);
    }
}