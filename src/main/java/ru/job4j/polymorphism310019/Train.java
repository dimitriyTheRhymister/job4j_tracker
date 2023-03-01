package ru.job4j.polymorphism310019;

public class Train implements  Vehicle {
    private final String name;

    public Train(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("\t- the train, f.e. " + "\"" + name + "\"," + " moves along the rails,");
    }
}
