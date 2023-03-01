package ru.job4j.polymorphism310019;

public class Plane implements  Vehicle {
    private final String name;

    public Plane(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("\t- the plane, f.e. " + "\"" + name + "\"," + " flies through the air,");
    }
}
