package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        Shape t = new Triangle();
        Shape s = new Square();
        context.draw(t);
        context.draw(s);
    }
}