package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ivan@list.ru", "Ivan Ivanov");
        hashMap.put("stepan@yandex.ru", "Stepan Ыеузфтщм");
        hashMap.put("petr@gmail.com", "Petr Petrov");
        System.out.println("Элементы коллекции:");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
