package test;

import model.Ruolo;
import model.Utente;
import repository.RepoUtenti;

import java.time.LocalDate;

/**
 * Classe di test per verificare il corretto funzionamento
 * delle operazioni di ricerca e verifica delle password
 * nella repository degli utenti.
 *
 * <p>La classe verifica la possibilità di recuperare un utente
 * tramite username e di controllare la correttezza della password
 * attraverso il metodo {@link Utente#verificaPassword(String)}.</p>
 */
public class TestRepo {

    /**
     * Metodo principale della classe.
     *
     * <p>Inizializza la repository degli utenti e ricerca un utente
     * tramite il suo username. Se l'utente viene trovato, vengono
     * eseguiti due test:</p>
     *
     * <ul>
     *     <li>Verifica della password corretta;</li>
     *     <li>Verifica di una password errata.</li>
     * </ul>
     *
     * <p>Gli esiti delle verifiche vengono stampati a console.
     * Se l'utente non viene trovato, viene visualizzato un
     * messaggio di errore.</p>
     *
     * @param args eventuali argomenti passati da riga di comando
     */
    public static void main(String[] args) {

        RepoUtenti repo = new RepoUtenti();

        // Cerca Giulia nella repository
        Utente utente = repo.cercaPerUsername("gneri");

        if (utente != null) {

            // Test con password corretta
            boolean passwordCorretta = utente.verificaPassword("giulia123");

            // Test con password sbagliata
            boolean passwordErrata = utente.verificaPassword("password123");

            System.out.println("Password corretta: " + passwordCorretta);
            System.out.println("Password errata: " + passwordErrata);

        } else {
            System.out.println("Utente non trovato.");
        }
    }
}