package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        int arrayLength = Math.min(left.length(), right.length());
        for (int l = 0; l < arrayLength; l++) {
            for (int i = 0; i < arrayLength; i++) {
                if (left.charAt(l) < right.charAt(l)) {
                    res = -1;
                    break;
                }
                if (left.charAt(l) > right.charAt(l)) {
                    res = 1;
                    break;
                }
            }
        }
        if (res == 0 && left.length() < right.length()) {
            res = -1;
        }
        if (res == 0 && left.length() > right.length()) {
            res = 1;
        }
        return res;
    }
}