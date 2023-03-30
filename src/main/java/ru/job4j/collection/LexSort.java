package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftStr = left.split(" ")[0];
        String rightStr = right.split(" ")[0];
        int leftNum = Integer.parseInt(leftStr.substring(0, leftStr.length() - 1));
        int rightNum = Integer.parseInt(rightStr.substring(0, rightStr.length() - 1));

        return leftNum > rightNum ? 1 : -1;
    }
}