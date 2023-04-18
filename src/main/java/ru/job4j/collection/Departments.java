package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            if (value.length() == 3) {
                tmp.add(value.substring(0, 2));
            }
            if (value.length() == 6) {
                tmp.add(value);
                tmp.add(value.substring(0, 2));
            }
            if (value.length() == 11) {
                tmp.add(value);
                tmp.add(value.substring(0, 2));
                tmp.add(value.substring(0, 6));
            }
        }
        List<String> rsl = new ArrayList<>(tmp);

        sortAsc(rsl);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

}