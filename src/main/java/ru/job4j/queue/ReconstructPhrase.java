package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int idx = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : evenElements) {
            if (idx % 2 == 0) {
                stringBuilder.append(c);
            }
            idx++;
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        int size = descendingElements.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(descendingElements.pollLast());
        }
        return String.valueOf(stringBuilder);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}