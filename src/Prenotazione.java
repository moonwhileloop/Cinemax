public class Prenotazione {
    private String codicePrenotazione;
    private Utente cliente;
    private Proiezioni proiezione;
    private int numeroBigliettiPrenotati;

    public Prenotazione(String codicePrenotazione, Utente cliente, Proiezioni proiezione, int numeroBigliettiPrenotati) {

        this.codicePrenotazione = codicePrenotazione;
        this.cliente = cliente;
        this.proiezione = proiezione;
        this.numeroBigliettiPrenotati = numeroBigliettiPrenotati;
    }

    public String getCodicePrenotazione() {
        return codicePrenotazione;
    }
    public void setCodicePrenotazione(String codicePrenotazione) {
        this.codicePrenotazione = codicePrenotazione;
    }
    public Utente getCliente() {
        return cliente;
    }
    public void setCliente(Utente cliente) {
        this.cliente = cliente;
    }
    public Proiezioni getProiezione() {
        return proiezione;
    }
    public void setProiezione(Proiezioni proiezione) {
        this.proiezione = proiezione;
    }
    public int getNumeroBigliettiPrenotati() {
        return numeroBigliettiPrenotati;
    }
    public void setNumeroBigliettiPrenotati(int numeroBigliettiPrenotati) {
        this.numeroBigliettiPrenotati = numeroBigliettiPrenotati;
    }
    public double getCostoTotale() {
        return proiezione.getCostoBiglietto() * numeroBigliettiPrenotati;
    }

    @Override
    public String toString() {
        return "Prenotazione: " +
                "codice prenotazione= " + codicePrenotazione + '\'' +
                ", cliente= " + cliente +
                ", proiezione= " + proiezione +
                ", numero di biglietti prenotati=" + numeroBigliettiPrenotati;
    }
}
