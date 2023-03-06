package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User '" + login + "' Not Found!");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            rsl = false;
            throw new UserInvalidException("User '" + user.getUsername() + "' Invalid!");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}