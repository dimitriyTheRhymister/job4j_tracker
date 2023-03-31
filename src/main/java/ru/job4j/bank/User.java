package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных - клиент в банке
 * @author rhymister19@gmail.com
 * @version 1.0
 */
public class User {
    /**
     * Поле типа String - хранит № паспорта клиента
     */
    private String passport;
    /**
     * Поле типа String - хранит имя клиента
     */
    private String username;

    /**
     * Конструкторо класса - инициализирует поля класса
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод - "геттер" - для получения значение типа String поля паспорт
     * @return возвращает значение типа String поля паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод - "сеттер" - устанавливает значение типа String поля паспорт
     * @param passport - строка для записи в поле паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод - "геттер" - для получения значение типа String поля имя
     * @return возвращает значение типа String поля имя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод - "сеттер" - устанавливает значение типа String поля имя
     * @param username - строка для записи в поле имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "passport='" + passport
                + '\''
                +
                ", username='" + username
                + '\''
                +
                '}';
    }
}