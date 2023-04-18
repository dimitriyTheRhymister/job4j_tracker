package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.charAt(1) == s2.charAt(1) ? s1.compareTo(s2) : s2.compareTo(s1);
    }
}