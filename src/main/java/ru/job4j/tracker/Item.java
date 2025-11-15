package ru.job4j.tracker;

import lombok.Data;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(Integer id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }
}
