package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        for (User key : users.keySet()) {
            if (Objects.equals(key.getPassport(), passport)) {
                users.remove(key);
                return true;
            }
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = getAccounts(user);
        if (!list.contains(account)) {
            list.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User keyUser : users.keySet()) {
            if (Objects.equals(keyUser.getPassport(), passport)) {
                return keyUser;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = new ArrayList<>();
        User user = findByPassport(passport);
        if (user != null) {
            list = getAccounts(user);
        }
        for (Account account : list) {
            if (Objects.equals(account.getRequisite(), requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountDest = findByRequisite(destPassport, destRequisite);
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        if (accountSrc == null || accountDest == null || accountSrc.getBalance() < amount) {
            return false;
        }
        User user = findByPassport(srcPassport);
        List<Account> list = getAccounts(user);

        if (list.contains(accountDest)) {
            accountDest.setBalance(accountDest.getBalance() + accountSrc.getBalance());
        }
        if (list.contains(accountSrc)) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
        }
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}