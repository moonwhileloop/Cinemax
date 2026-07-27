import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Proiezioni {

    private static final int POSTI_TOTALI = 200;

    private int idProiezione;
    private Film film;
    private LocalDateTime dataEoraInizio;
    private double costoBiglietto;

    private static final DateTimeFormatter FORMATTER_DATA_ORA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Proiezioni(int idProiezione, Film film, LocalDateTime dataEoraInizio, double costoBiglietto) {
        this.idProiezione = idProiezione;
        this.film = film;
        this.dataEoraInizio = dataEoraInizio;
        this.costoBiglietto = costoBiglietto;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getDataEoraInizio() {
        return dataEoraInizio;
    }

    public void setDataEoraInizio(LocalDateTime dataEoraInizio) {
        this.dataEoraInizio = dataEoraInizio;
    }

    public double getCostoBiglietto() {
        return costoBiglietto;
    }

    public void setCostoBiglietto(double costoBiglietto) {
        this.costoBiglietto = costoBiglietto;
    }

    public int getPostiDisponibili(int postiPrenotati) {
        return POSTI_TOTALI - postiPrenotati;
    }

    @Override
    public String toString() {
        return "Proiezione: " +
                "film= " + film +
                ", data e ora inizio film = " + dataEoraInizio.format(FORMATTER_DATA_ORA)+
                ", costo del biglietto= " + costoBiglietto;
    }

}

