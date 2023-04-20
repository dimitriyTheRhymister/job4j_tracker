package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int result = s2.split("/")[0].compareTo(s1.split("/")[0]);
        return result != 0 ? result : s1.compareTo(s2);
    }
}