package service;

import model.Utente;
import repository.RepoUtenti;

import java.time.LocalDate;

/**
 * Classe che gestisce le operazioni relative agli utenti del sistema CINEMAX.
 *
 * <p>Si occupa della registrazione, dell'autenticazione,
 * della ricerca e della validazione dei dati degli utenti,
 * delegando l'accesso e la gestione dei dati alla
 * repository {@link RepoUtenti}.</p>
 */
public class GestioneUtenti {

    private final RepoUtenti repoUtenti;

    /**
     * Crea un gestore degli utenti utilizzando la repository specificata.
     *
     * @param repoUtenti repository utilizzata per accedere e gestire
     *                   i dati degli utenti
     * @throws IllegalArgumentException se la repository è null
     */
    public GestioneUtenti(RepoUtenti repoUtenti) {
        if (repoUtenti == null) {
            throw new IllegalArgumentException("La repository non può essere null.");
        }

        this.repoUtenti = repoUtenti;
    }

    /**
     * Registra un nuovo cliente nel sistema.
     *
     * <p>Delega alla repository l'aggiunta dell'utente e il salvataggio
     * dei relativi dati.</p>
     *
     * @param utente utente da registrare
     * @return {@code true} se la registrazione è avvenuta con successo,
     *         {@code false} altrimenti
     */
    public boolean registrazioneCliente(Utente utente) {
        if (utente == null)
            return false;

        return repoUtenti.aggiungiUtente(utente);
    }

    /**
     * Effettua l'autenticazione di un utente tramite email e password.
     *
     * <p>Ricerca l'utente nella repository attraverso l'indirizzo email
     * e verifica la correttezza della password inserita.
     * Se le credenziali risultano valide, restituisce l'utente autenticato;
     * in caso contrario, restituisce {@code null}.</p>
     *
     * @param mail indirizzo email dell'utente
     * @param password password inserita dall'utente
     * @return l'utente autenticato se le credenziali sono valide,
     *         {@code null} altrimenti
     */
    public Utente loginUtente(String mail, String password) {

        if (mail == null || mail.isBlank() || password == null) {
            return null;
        }

        Utente utente = repoUtenti.cercaPerMail(mail);

        if (utente != null && utente.verificaPassword(password)) {
            return utente;
        }

        return null;
    }

    /**
     * Verifica che la data di nascita inserita sia precedente alla data odierna.
     *
     * @param dataNascita data di nascita da verificare
     * @return {@code true} se la data è valida, {@code false} altrimenti
     */
    public boolean verificaDataNascita(LocalDate dataNascita) {
        return dataNascita != null && dataNascita.isBefore(LocalDate.now());
    }

    /**
     * Verifica che tutti i campi obbligatori dell'utente siano compilati.
     *
     * <p>Controlla nome, cognome, email, username, domicilio e password.
     * Restituisce il nome del primo campo mancante o vuoto.</p>
     *
     * @param utente utente di cui verificare i dati
     * @return il nome del primo campo non compilato,
     *         oppure {@code null} se tutti i campi sono presenti
     */
    public String verificaCampiObbligatori(Utente utente) {

        if (utente == null)
            return "utente";

        if (utente.getNome() == null || utente.getNome().isBlank())
            return "nome";

        if (utente.getCognome() == null || utente.getCognome().isBlank())
            return "cognome";

        if (utente.getEmail() == null || utente.getEmail().isBlank())
            return "email";

        if (utente.getUsername() == null || utente.getUsername().isBlank())
            return "username";

        if (utente.getDomicilio() == null || utente.getDomicilio().isBlank())
            return "domicilio";

        if (utente.getPasswordHash() == null || utente.getPasswordHash().isBlank())
            return "password";

        return null;
    }

    /**
     * Verifica che una password rispetti i requisiti minimi di sicurezza.
     *
     * <p>La password deve contenere almeno 8 caratteri, una lettera
     * maiuscola, una lettera minuscola, un numero e un carattere speciale.</p>
     *
     * @param password password da verificare
     * @return {@code true} se la password rispetta tutti i requisiti,
     *         {@code false} altrimenti
     */
    public boolean verificaPassword(String password) {

        if (password == null || password.length() < 8)
            return false;

        return password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^A-Za-z0-9].*");
    }

    /**
     * Cerca un utente registrato tramite il suo indirizzo email.
     *
     * @param email indirizzo email dell'utente da cercare
     * @return l'utente corrispondente all'email,
     *         oppure {@code null} se non viene trovato
     */
    public Utente cercaUtentePerMail(String email) {
        if (email == null || email.isBlank())
            return null;

        return repoUtenti.cercaPerMail(email);
    }

    /**
     * Cerca un utente registrato tramite il suo username.
     *
     * @param username username dell'utente da cercare
     * @return l'utente corrispondente,
     *         oppure {@code null} se non viene trovato
     */
    public Utente cercaUtentePerUsername(String username) {
        if (username == null || username.isBlank())
            return null;

        return repoUtenti.cercaPerUsername(username);
    }

}