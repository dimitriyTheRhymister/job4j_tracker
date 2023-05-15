package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> doesNameContain = (person) -> person.getName().contains(key);
        Predicate<Person> doesSurnameContain = (person) -> person.getSurname().contains(key);
        Predicate<Person> doesPhoneContain = (person) -> person.getPhone().contains(key);
        Predicate<Person> doesAddressContain = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine = doesNameContain.or(doesSurnameContain).or(doesPhoneContain).or(doesAddressContain);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}