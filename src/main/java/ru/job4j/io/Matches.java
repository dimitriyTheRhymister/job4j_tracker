package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches < 4) {
                if (matches > count) {
                    System.out.println("Ваше число > чем количество спичек на столе. "
                            + player
                            + ", попробуем ещё разок?!");
                } else {
                    count -= matches;
                    System.out.println(count + " спичек осталось на столе");
                    turn = !turn;
                }
            } else {
                System.out.println("Нужно ввести число от 1 до 3 (включительно). "
                        + player
                        + ", попробуем ещё разок?!");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок!");
        } else {
            System.out.println("Выиграл второй игрок!");
        }
    }
}