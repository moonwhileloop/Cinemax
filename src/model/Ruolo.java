package model;

/**
 * Definisce i ruoli disponibili per gli utenti registrati all'interno dell'applicazione CineMax.
 *
 * <p>
 *     Il ruolo determina le funzionalità a cui un utente può accedere dopo aver
 *     effettuato il login
 * </p>
 * @author Martina Molteni
 * @version 1.0
 */
public enum Ruolo {
    /** Cliente registrato che può effettuare e gestire le proprie prenotazioni. */
    CLIENTE,
    /** Operatore incaricato della ricerca e visualizzazione delle prenotazioni. */
    BIGLIETTAIO,
    /** Operatore incaricato della gestione del palinsesto delle proiezioni. */
    PROIEZIONISTA
}
