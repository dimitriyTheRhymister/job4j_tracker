package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("Volvo");
        autos.add("BMW");
        autos.add("Lada");
        autos.add("Volvo");
        autos.add("Lada");
        autos.add("Toyota");
        for (String name : autos) {
            System.out.println(name);
        }
    }
}