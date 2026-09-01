package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Rappresenta una proiezione cinematografica.
 *
 * <p>
 *     una proiezione associa un film a una specifica data e ora di inizio
 *     e definisce il costo del relativo biglietto.
 *     Ogni proiezione è identificata da un codice univoco e si svolge in una sala con una capienza massima di 200 posti.
 * </p>
 *
 * @author Martina Molteni
 * @version 1.0
 */

public class Proiezioni {

    private static final int POSTI_TOTALI = 200;

    private int idProiezione;
    private Film film;
    private LocalDateTime dataEoraInizio;
    private double costoBiglietto;

    private static final DateTimeFormatter FORMATTER_DATA_ORA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Crea una nuova proiezione
     *
     * @param idProiezione identificativo univoco della proiezione
     * @param film film associato alla proiezione
     * @param dataEoraInizio data e ora di inizio della proiezione
     * @param costoBiglietto costo del biglietto della proiezione
     */

    public Proiezioni(int idProiezione, Film film, LocalDateTime dataEoraInizio, double costoBiglietto) {
        this.idProiezione = idProiezione;
        this.film = film;
        this.dataEoraInizio = dataEoraInizio;
        this.costoBiglietto = costoBiglietto;
    }

    /**
     * Restituisce il titolo del film, il genere, la durata e l'età minima
     * @return il film proiettato
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Imposta il film
     * @param film : il film da inserire
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Restituisce l'id univoco della proiezione
     * @return l'id del film proiettato
     */
    public int getIdProiezione() {
        return idProiezione;
    }

    /**
     * Imposta l'id della proiezione
     * @param idProiezione id della proiezione
     */
    public void setIdProiezione(int idProiezione) {
        this.idProiezione = idProiezione;
    }

    /**
     * Restituisce la data e l'ora di inizio del film
     * @return la data e l'ora di inizio della proiezione
     */
    public LocalDateTime getDataEoraInizio() {
        return dataEoraInizio;
    }

    /**
     * imposta la data e l'ora di inizio del film
     * @param dataEoraInizio la data e l'ora di inizio del film
     */
    public void setDataEoraInizio(LocalDateTime dataEoraInizio) {
        this.dataEoraInizio = dataEoraInizio;
    }

    /**
     * Restituisce il costo del biglietto
     * @return il costo unitario del biglietto per quella specifica proiezione
     */
    public double getCostoBiglietto() {
        return costoBiglietto;
    }

    /**
     * Imposta il costo del biglietto per la proiezione
     * @param costoBiglietto costo del biglietto della proiezione
     */
    public void setCostoBiglietto(double costoBiglietto) {
        this.costoBiglietto = costoBiglietto;
    }

    /**
     * Calcola il numero di posti disponibili sottraendo i posti già prenotati
     *dalla capienza totale della sala.
     * @param postiPrenotati numero di posti già prenotati per la proiezione
     * @return i posti ancora disponibili totali per la proiezione
     */
    public int getPostiDisponibili(int postiPrenotati) {
        return POSTI_TOTALI - postiPrenotati;
    }

    /**
     * Restituisce una rappresentazione testuale della proiezione.
     * <p> La stringa contiene le informazioni principali della proiezione,
     * tra cui il film, la data e l'ora di inizio e il costo del biglietto.
     * @return una stringa contenente i dati della proiezione
     */
    @Override
    public String toString() {
        return "Proiezione: " +
                "film= " + film +
                ", data e ora inizio film = " + dataEoraInizio.format(FORMATTER_DATA_ORA)+
                ", costo del biglietto= " + costoBiglietto;
    }

}

