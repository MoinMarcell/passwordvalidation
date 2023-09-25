package de.neuefische;

public class PasswordValidator {

    private static final String[] KNOWN_PASSWORDS = {
            "12345678",
            "password",
            "123456789",
            "1234567890",
            "qwertyuiop",
            "test",
            "1234567",
            "123456",
            "12345",
            "1234",
            "123",
            "12",
            "1",
            "p",
            "pa",
            "pas",
            "pass",
            "passw",
            "passwo",
            "passwor",
            "qwertz",
            "asdfgh",
            "zxcvbn"
    };

    public static boolean hasMinimumLengthOfEightCharacters(String password) {
        return password.length() >= 8;
    }

    public static boolean includesAtLeastOneDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAtLeastOneUppercaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAtLeastOneLowercaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAtLeastOneSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKnownPassword(String password) {
        for (String knownPassword : KNOWN_PASSWORDS) {
            if (password.equals(knownPassword)) {
                return true;
            }
        }
        return false;
    }

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder();
        while (!hasMinimumLengthOfEightCharacters(password.toString())
                || !includesAtLeastOneDigit(password.toString())
                || !hasAtLeastOneUppercaseLetter(password.toString())
                || !hasAtLeastOneLowercaseLetter(password.toString())
                || !hasAtLeastOneSpecialCharacter(password.toString())
                || isKnownPassword(password.toString())) {
            password = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                password.append((char) (Math.random() * 94 + 33));
            }
        }
        return password.toString();
    }
}
