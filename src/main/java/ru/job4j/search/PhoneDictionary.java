package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> p1 = (Person) -> Person.getName().contains(key);
        Predicate<Person> p2 = (Person) -> Person.getSurname().contains(key);
        Predicate<Person> p3 = (Person) -> Person.getPhone().contains(key);
        Predicate<Person> p4 = (Person) -> Person.getAddress().contains(key);
        Predicate<Person> combine = p1.or(p2).or(p3).or(p4);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}