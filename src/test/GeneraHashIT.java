package test;

import Util.PasswordUtil;

/**
 * Classe di test utilizzata per generare e visualizzare l'hash
 * di una password tramite il metodo {@link PasswordUtil#hashPassword(String)}.
 *
 * <p>La classe permette di verificare il corretto funzionamento
 * del metodo di hashing definito in {@code PasswordUtil}.</p>
 *
 * @author
 */
public class GeneraHashIT {

    /**
     * Metodo principale della classe.
     *
     * <p>Genera l'hash della password specificata e lo stampa
     * a console.</p>
     *
     * @param args eventuali argomenti passati da riga di comando
     */
    public static void main(String[] args) {
        String password = "CinemaIT2026";
        System.out.println(PasswordUtil.hashPassword(password));
    }
}