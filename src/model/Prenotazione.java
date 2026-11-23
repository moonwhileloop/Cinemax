package model;

/** Rappresenta una prenotazione effettuata da un cliente per una
 * specifica proiezione cinematografica.
 * <p>
 *     Ogni prenotazione è identificata da un codice univoco ed è
 *  * associata a un cliente, a una proiezione e al numero di biglietti preno
 *
 * </p>
 *
 * @author Martina Molteni
 * @version 1.0
 */

public class Prenotazione {
    private String codicePrenotazione;
    private Utente cliente;
    private Proiezioni proiezione;
    private int numeroBigliettiPrenotati;

    /**
     * Crea le specifiche della prenotazione
     * @param codicePrenotazione codice univoco della prenotazione della proiezione
     * @param cliente cliente che effettua la prenotazione
     * @param proiezione proiezione per cui viene effettuata la prenotazione
     * @param numeroBigliettiPrenotati numero di biglietti prenotati
     */

    public Prenotazione(String codicePrenotazione, Utente cliente, Proiezioni proiezione, int numeroBigliettiPrenotati) {

        this.codicePrenotazione = codicePrenotazione;
        this.cliente = cliente;
        this.proiezione = proiezione;
        this.numeroBigliettiPrenotati = numeroBigliettiPrenotati;
    }

    /**
     * Restituisce il codice univoco della prenotazione
     * @return codice univoco della prenotazione
     */
    public String getCodicePrenotazione() {
        return codicePrenotazione;
    }

    /**
     * imposta il codice della prenotazione
     * @param codicePrenotazione il codice della prenotazione
     */
    public void setCodicePrenotazione(String codicePrenotazione) {
        this.codicePrenotazione = codicePrenotazione;
    }

    /**
     * Restituisce il cliente che ha effettuato la prenotazione
     * @return il cliente della prenotazione
     */
    public Utente getCliente() {
        return cliente;
    }

    /**
     * Imposta il cliente che ha effettuato la prenotazione
     * @param cliente cliente che ha effettuato la prenotazione
     */
    public void setCliente(Utente cliente) {
        this.cliente = cliente;
    }

    /**
     * Restituisce la proiezione prenotata
     * @return proiezione prenotata
     */
    public Proiezioni getProiezione() {
        return proiezione;
    }

    /**
     * Imposta la proiezione da prenotare
     * @param proiezione proiezione da prenotare
     */
    public void setProiezione(Proiezioni proiezione) {
        this.proiezione = proiezione;
    }

    /**
     * Restituisce il numero di biglietti prenotati
     * @return il numero di biglietti prenotati
     */
    public int getNumeroBigliettiPrenotati() {
        return numeroBigliettiPrenotati;
    }

    /**
     * Imposta il numero di biglietti da prenotare
     * @param numeroBigliettiPrenotati numero biglietti prenotati
     */
    public void setNumeroBigliettiPrenotati(int numeroBigliettiPrenotati) {
        this.numeroBigliettiPrenotati = numeroBigliettiPrenotati;
    }

    /**
     * Restituisce il costo totale della prenotazione
     * @return il costo totale della prenotazione
     */
    public double getCostoTotale() {
        return proiezione.getCostoBiglietto() * numeroBigliettiPrenotati;
    }

    /**
     * Restituisce una rappresentazione testuale della prenotazione
     *  <p>La stringa contiene le principali informazioni della prenotazione effettuata, tra cui il cliente
     *  che ha effettuato la prenotazione,
     *      * domicilio e ruolo. </p>
     * @return una stringa contenente i dati della prenotazione
     */
    @Override
    public String toString() {
        return "model.Prenotazione: " +
                "codice prenotazione= " + codicePrenotazione + '\'' +
                ", cliente= " + cliente +
                ", proiezione= " + proiezione +
                ", numero di biglietti prenotati=" + numeroBigliettiPrenotati;
    }
}
