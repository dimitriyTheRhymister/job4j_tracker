package ru.job4j.polymorphism310019;

public interface Vehicle {
    String MODERN = "Plane, train, bus";

    default void modern() {
        System.out.println(MODERN + " are modern means of transportation, but:");
    }

    void move();
}
