package ru.job4j.polymorphism310019;

public class Bus implements Vehicle {
    private final String name;

    public Bus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("\t- the bus, f.e. " + "\"" + name + "\"," + " moves along the highways.");
    }
}