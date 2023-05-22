package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionary2Test {
    @Test
    public void whenFindByName() {
        PhoneDictionary2 phones = new PhoneDictionary2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNoFindByName() {
        PhoneDictionary2 phones = new PhoneDictionary2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Pavel");
        assertThat(persons.size()).isEqualTo(0);
    }
}