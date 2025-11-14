package ru.job4j.lombok;

import ru.job4j.tracker.ItemData;

public class LombokUsage {
    public static void main(String[] args) {
        var bird = new BirdData();
        bird.setAge(1);
        System.out.println(bird);

        var item = new ItemData();
        item.setId(1);
        System.out.println(item);

        var role = Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);

        var permission = Permission.of()
                .id(1)
                .name("ADMIN")
                .rules("create")
                .rules("update")
                .rules("read")
                .rules("delete")
                .build();
        System.out.println(permission);
    }
}
