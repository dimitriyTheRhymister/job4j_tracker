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
        for (int i = 0; i < password.length() && !hasUpperCase; i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        boolean hasLowerCase = false;
        for (int i = 0; i < password.length() && !hasLowerCase; i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
            }
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        boolean hasDigits = false;
        for (int i = 0; i < password.length() && !hasDigits; i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigits = true;
            }
        }
        if (!hasDigits) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        boolean hasSpecialSymbol = false;
        for (int i = 0; i < password.length() && !hasSpecialSymbol; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                hasSpecialSymbol = true;
            }
        }
        if (!hasSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        boolean hasSubstring = password.toLowerCase().contains("qwerty".toLowerCase())
                || password.toLowerCase().contains("12345".toLowerCase())
                || password.toLowerCase().contains("password".toLowerCase())
                || password.toLowerCase().contains("admin".toLowerCase())
                || password.toLowerCase().contains("user".toLowerCase());
        if (hasSubstring) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    public static void main(String[] args) {
        System.out.println(validate("rusrTr&rrr1245op"));
    }
}