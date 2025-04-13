package ru.job4j.tracker;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.sql.SQLException;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
            System.out.println("Заявка № " + i);
        }
        out.println("Добавлено заявок: " + count);
        System.out.println("Добавлено заявок: " + count);
        return true;
    }

    public static void main(String[] args) throws SQLException {
        Input input = new ConsoleInput();

        Output output = new ConsoleOutput();

        Store tracker = new MemTracker();

        CreateManyItems createManyItems = new CreateManyItems(output);
        System.out.println(createManyItems.execute(input, tracker));
    }
}