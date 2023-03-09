package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        boolean hasUpperCase = true;
        boolean hasSpecialSymbol = true;
        boolean hasLowerCase = true;
        boolean hasDigits = true;
        char[] charArr = password.toCharArray();
        for (char c : charArr) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = false;
                continue;
            }
            if (Character.isLowerCase(c)) {
                hasLowerCase = false;
                continue;
            }
            if (Character.isDigit(c)) {
                hasDigits = false;
                continue;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialSymbol = false;
            }
        }
        if (hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (hasDigits) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (hasSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        boolean hasSubstring = false;
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String substring : substrings) {
            if (password.toLowerCase().contains(substring.toLowerCase())) {
                hasSubstring = true;
                break;
            }
        }
        if (hasSubstring) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    public static void main(String[] args) {
        System.out.println(validate("ruTrrrr1245op"));
    }
}