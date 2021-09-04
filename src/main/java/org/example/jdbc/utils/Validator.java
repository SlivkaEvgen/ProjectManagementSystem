package org.example.jdbc.utils;

public class Validator {

    public static boolean validNumber(String hasNumbers) {
        return hasNumbers.matches("\\d+");
    }

    public static boolean validString(String hasLetters) {
        return !hasLetters.matches("\\d+");
    }
}
