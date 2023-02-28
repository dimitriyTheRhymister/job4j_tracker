package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        int answerInt = new Random().nextInt(3);
        String answer = switch (answerInt) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        };
        String question = input.nextLine();
        System.out.println("Ответ на вопрос: '" + question + "' - " + answer);
    }
}
