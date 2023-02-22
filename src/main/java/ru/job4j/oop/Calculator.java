package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        int result2 = minus(10);
        System.out.println(result);
        System.out.println(result2);
        Calculator calc = new Calculator();
        int rsl = calc.multiply(10);
        int rsl2 = calc.divide(10);
        int rsl3 = calc.sumAllOperation(10);
        System.out.println(rsl);
        System.out.println(rsl2);
        System.out.println(rsl3);
    }
}