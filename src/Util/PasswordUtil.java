package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * Classe di utilità per la gestione dell'hashing delle password.
 *
 * <p>Utilizza l'algoritmo SHA-256 per generare l'hash di una password,
 * convertendo il risultato in una stringa esadecimale.</p>
 *
 * <p>La classe non può essere istanziata, poiché contiene esclusivamente
 * metodi statici.</p>
 *
 * @author
 */
public class PasswordUtil {

    /**
     * Costruttore privato per impedire l'istanziazione della classe.
     */
    private PasswordUtil() {
        // Evita che altri possano creare istanze di questa classe.
    }

    /**
     * Genera l'hash SHA-256 della password ricevuta.
     *
     * <p>La password viene convertita in byte utilizzando la codifica UTF-8,
     * elaborata tramite l'algoritmo SHA-256 e successivamente convertita
     * in una stringa esadecimale.</p>
     *
     * @param password password da sottoporre ad hashing
     * @return stringa esadecimale contenente l'hash SHA-256 della password
     * @throws RuntimeException se l'algoritmo SHA-256 non è disponibile
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder passwordHash = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    passwordHash.append('0');
                }

                passwordHash.append(hex);
            }

            return passwordHash.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(
                    "Errore durante il calcolo dell'hash della password.", e
            );
        }
    }
}