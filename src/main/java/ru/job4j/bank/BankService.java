package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает операции с клиентом в банке
 *
 * @author rhymister19@gmail.com
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция типа HashMap - хранит список клиентов банка
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод - добавляет клиента в поле клиенты банка
     *
     * @param user - объект клиента для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод - удаляет клиента из поля клиенты банка
     *
     * @param passport - паспорт клиента, которого нужно удалить
     * @return возвращает удалённого клиента или null, если клиента с таким паспортом нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод - добавляет счёт клиенту банка
     *
     * @param passport - паспорт клиента, которому нужно добавить счёт
     * @param account  - счёт, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод - ищет клиента банка по паспорту
     *
     * @param passport - паспорт клиента, которого нужно найти
     * @return возвращает найденного клиента или null, если клиента с таким паспортом нет
     */
    public User findByPassport(String passport) {
        for (User keyUser : users.keySet()) {
            if (Objects.equals(keyUser.getPassport(), passport)) {
                return keyUser;
            }
        }
        return null;
    }

    /**
     * Метод - ищет счйт в банке по паспорту клиента и реквизиту счйта
     *
     * @param passport  - паспорт клиента, счйт которого нужно найти
     * @param requisite - реквизит счёта, который нужно найти
     * @return возвращает найденный счёт клиента или null, если такого счёта нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод - осуществляет перевод со счёта на счёт клиента в банке по номеру паспорта клиента и реквизиту счйта
     * @param srcPassport   - паспорт клиента, с которого нужно перевести
     * @param srcRequisite  - реквизит счёта, с которого нужно перевести
     * @param destPassport  - паспорт клиента, на который нужно перевести
     * @param destRequisite - реквизит счёта, на который нужно перевести
     * @param amount - сколько средств нужно перевести
     * @return возвращает true, если перевод прошёл успешно и false, если отсутствуют необходимые для перевода счет отправителя или получателя или если на счёте отправителя недостаточно средств для перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountDest = findByRequisite(destPassport, destRequisite);
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        if (accountSrc == null || accountDest == null || accountSrc.getBalance() < amount) {
            return false;
        }
        accountDest.setBalance(accountDest.getBalance() + amount);
        accountSrc.setBalance(accountSrc.getBalance() - amount);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}