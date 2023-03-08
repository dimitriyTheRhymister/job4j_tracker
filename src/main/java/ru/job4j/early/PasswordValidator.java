package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        boolean hasUpperCase = false;
        boolean hasSpecialSymbol = false;
        boolean hasLowerCase = false;
        boolean hasDigits = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigits = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                hasSpecialSymbol = true;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigits) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecialSymbol) {
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
        System.out.println(validate("ruTrr&rr1245op"));
    }
}