package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PassportOffice {
    private final Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        for (String key : citizens.keySet()) {
            if (Objects.equals(citizens.get(key).getPassport(), passport)) {
                return citizens.get(key);
            }
        }
        return null;
    }
}