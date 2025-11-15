package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void sortByIdWithComparable() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix"),
                new Item(2, "Impl"),
                new Item(1, "Rebootr")
        );
        List<Item> expected = new ArrayList<>();
        Item i3 = new Item(1, "Rebootr");
        Item i2 = new Item(2, "Impl");
        Item i1 = new Item(4, "Fix");
        expected.add(i3);
        expected.add(i2);
        expected.add(i1);
        Collections.sort(items);
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void sortByNameAscWithComparator() {
        List<Item> items = Arrays.asList(
                new Item(1, "Rebootr"),
                new Item(2, "Impl"),
                new Item(4, "Fix")
        );
        List<Item> expected = new ArrayList<>();
        Item i1 = new Item(4, "Fix");
        Item i2 = new Item(2, "Impl");
        Item i3 = new Item(1, "Rebootr");
        expected.add(i1);
        expected.add(i2);
        expected.add(i3);
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void sortByNameDescWithComparator() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix"),
                new Item(2, "Impl"),
                new Item(1, "Rebootr")
        );
        List<Item> expected = new ArrayList<>();
        Item i1 = new Item(1, "Rebootr");
        Item i2 = new Item(2, "Impl");
        Item i3 = new Item(4, "Fix");
        expected.add(i1);
        expected.add(i2);
        expected.add(i3);
        items.sort(new ItemDescByName());
        assertThat(items).usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }
}