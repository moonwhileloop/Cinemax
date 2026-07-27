import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;
    private LocalDate dataNascita;
    private String domicilio;
    private Ruolo ruolo;

    private static final DateTimeFormatter FORMATTER_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Utente(String nome, String cognome, String email, String username, String password, LocalDate dataNascita, String domicilio, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dataNascita = dataNascita;
        this.domicilio = domicilio;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { //da cifrare
        this.password = password;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public int getEta() {
        return Period.between(dataNascita, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Utente:\n" +
                "nome: " + nome + "\n" +
                "cognome: " + cognome + "\n" +
                "username: " + username + "\n" +
                "data di nascita: " + dataNascita.format(FORMATTER_DATA) + "\n" +
                "età: " + getEta() + "\n" +
                "domicilio: " + domicilio + "\n" +
                "ruolo: " + ruolo;
    }
}