package ru.job4j.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class User implements Comparable<User> {
    private final String name;

    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return name.compareTo(o.name) != 0 ? name.compareTo(o.name) : Integer.compare(age, o.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name
                + '\''
                +
                ", age="
                + age
                +
                '}';
    }

    public static void main(String[] args) {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 32));
        users.add(new User("Petr", 32));
        users.add(new User("Petr", 31));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        System.out.println(users.size());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

    }
}