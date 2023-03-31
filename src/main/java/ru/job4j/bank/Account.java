package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных - счёт в банке
 * @author rhymister19@gmail.com
 * @version 1.0
 */
public class Account {
    /**
     * Поле типа String - хранит реквизит счёта
     */
    private String requisite;
    /**
     * Поле типа double - хранит баланс счёта
     */
    private double balance;

    /**
     * Конструкторо класса - инициализирует поля класса
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод - "геттер" - для получения значение типа String поля реквизит
     * @return возвращает значение типа String поля реквизит
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод - "сеттер" - устанавливает значение типа String поля реквизит
     * @param requisite - строка для записи в поле реквизит
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод - "геттер" - для получения значение типа double поля баланс
     * @return возвращает значение типа double поля баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод - "сеттер" - устанавливает значение типа double поля баланс
     * @param balance - число для записи в поле баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "requisite='"
                + requisite
                + '\''
                +
                ", balance="
                + balance
                +
                '}';
    }
}