package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicate1 = (p) -> p.getName().contains(key);
        Predicate<Person> predicate2 = (p) -> p.getSurname().contains(key);
        Predicate<Person> predicate3 = (p) -> p.getPhone().contains(key);
        Predicate<Person> predicate4 = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = predicate1.or(predicate2).or(predicate3).or(predicate4);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}