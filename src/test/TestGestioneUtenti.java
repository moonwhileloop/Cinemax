package test;

import model.Utente;
import repository.RepoUtenti;
import service.GestioneUtenti;

/**
 * Classe di test per verificare il corretto funzionamento
 * dell'autenticazione degli utenti nel sistema CINEMAX.
 *
 * <p>La classe esegue diversi test sul metodo {@link GestioneUtenti#loginUtente(String, String)},
 * verificando il comportamento del sistema in presenza di credenziali valide,
 * password errate e indirizzi email non presenti nella repository.</p>
 */
public class TestGestioneUtenti {

    /**
     * Metodo principale della classe.
     *
     * <p>Inizializza la repository degli utenti e il gestore degli utenti,
     * quindi esegue tre test di autenticazione:</p>
     *
     * <ul>
     *     <li>Login con credenziali corrette;</li>
     *     <li>Login con password errata;</li>
     *     <li>Login con email inesistente.</li>
     * </ul>
     *
     * <p>Per ciascun test, stampa a console l'esito dell'autenticazione.</p>
     *
     * @param args eventuali argomenti passati da riga di comando
     */
    public static void main(String[] args) {

        RepoUtenti repoUtenti = new RepoUtenti();
        GestioneUtenti gestioneUtenti = new GestioneUtenti(repoUtenti);

        // Test 1: credenziali corrette
        Utente utente = gestioneUtenti.loginUtente(
                "giulia.neri@email.it",
                "giulia123"
        );

        if (utente != null) {
            System.out.println("Login riuscito: " + utente.getUsername());
        } else {
            System.out.println("Login fallito");
        }

        // Test 2: password errata
        Utente utenteErrato = gestioneUtenti.loginUtente(
                "giulia.neri@email.it",
                "password123"
        );

        if (utenteErrato != null) {
            System.out.println("Login riuscito");
        } else {
            System.out.println("Login fallito");
        }

        // Test 3: email inesistente
        Utente utenteInesistente = gestioneUtenti.loginUtente(
                "inesistente@email.it",
                "password123"
        );

        if (utenteInesistente != null) {
            System.out.println("Login riuscito");
        } else {
            System.out.println("Login fallito");
        }
    }
}