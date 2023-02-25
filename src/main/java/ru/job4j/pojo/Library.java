package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Bryus Ekkel - FilosofiaJava.", 789);
        Book book2 = new Book("Java 8. Полное руководство.", 945);
        Book book3 = new Book("Head First Java. Кэти Сиерра, Берт Бейтс.", 692);
        Book book4 = new Book("Clean code.", 489);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " " + b.getNumberOfPages() + " страниц.");
        }
        System.out.println();
        books[0] = book4;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " " + b.getNumberOfPages() + " страниц.");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if ("Clean code.".equals(b.getName())) {
                System.out.println(b.getName() + " " + b.getNumberOfPages() + " страниц.");
            }
        }
    }
}
