package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exiting the application";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
