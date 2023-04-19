package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Objects.equals(s1.split("/")[0], s2.split("/")[0]) ? s1.compareTo(s2) : s2.compareTo(s1);
    }
}