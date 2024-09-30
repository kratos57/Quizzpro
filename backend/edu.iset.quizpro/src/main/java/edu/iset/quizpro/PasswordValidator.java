package edu.iset.quizpro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty() || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Regex to validate password criteria
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{" + MIN_PASSWORD_LENGTH + ",}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
