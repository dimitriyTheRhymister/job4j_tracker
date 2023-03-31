package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftStr = left.split("\\.")[0];
        String rightStr = right.split("\\.")[0];
        int leftNum = Integer.parseInt(leftStr);
        int rightNum = Integer.parseInt(rightStr);

        return leftNum > rightNum ? 1 : -1;
    }
}