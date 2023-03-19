package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;

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
        Deque<Character> descendingElementsRev = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : descendingElements) {
            descendingElementsRev.addFirst(c);
        }
        for (Character c : descendingElementsRev) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}