package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private PasswordUtil() { //evita che il costruttore sia pubblico e altri possano creare password non proprie
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder passwordHash = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) passwordHash.append('0');
                passwordHash.append(hex);
            }

            return passwordHash.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Errore durante la cifratura della password.", e);
        }
}
