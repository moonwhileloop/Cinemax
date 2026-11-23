package model;

import Util.PasswordUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Rappresenta un utente registrato alla piattaforma Cinemax
 * <p>
 *     Contiene tutte gli attributi che si riferiscono all'utente.
 *     La classe contiene anche un ruolo che determina le funzionalità disponibili all'interno dell'applicazione.
 *
 *     I ruoli disponibili si ricollegano alla classe ENUM e sono:
 *     <ul>
 *         <li>CLIENTE</li>
 *         <li>BIGLIETTAIO</li>
 *         <li>PROIEZIONISTA</li>
 *     </ul>
 * </p>
 * @author Martina Molteni
 * @version 1.0
 */

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

    /**
     * Crea un utente inizializzando tutte le caratteristiche. Per essere creato, l'utente deve essere REGISTRATO.
     *
     * @param nome nome dell'utente
     * @param cognome cognome dell'utente
     * @param email email dell'utente
     * @param username username scelto dell'utente
     * @param password password scelta dall'utente
     * @param dataNascita data di nascita dell'utente. La data è stata resa obbligatoria per evitare prenotazioni di film non adatti all'età
     * @param domicilio domicilio dell'utente
     * @param ruolo ruolo utente (da scegliere tra ENUM)
     */


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

    /**
     * Restituisce il nome dell'utente registrato
     * @return nome: il nome dell'utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'utente
     * @param nome nome dell'utente
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome dell'utente registrato
     * @return cognome il cognome dell'utente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * imposta il cognome dell'utente
     * @param cognome il cognome dell'utente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce l'email dell'utente registrato
     * @return email l'email dell'utente
     */
    public String getEmail() {
        return email;
    }

    /**
     * imposta l'email dell'utente registrato
     * @param email email utente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce l'username dell'utente registrato
     * @return username l'username dell'utente
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta l'username dell'utente
     * @param username username dell'utente
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Imposta la password dell'utente
     * @param password password dell'utente
     */

    public void setPassword(String password) { //da cifrare
        this.password = password;
    }

    public String getPasswordHash() {
        return password;
    }

    /**
     * Verifica che la password inserita corrisponda
     * all'hash della password memorizzata per l'utente.
     *
     * @param passwordInserita password in chiaro inserita dall'utente
     * @return true se la password è corretta, false altrimenti
     */
    public boolean verificaPassword(String passwordInserita) {
        return password.equals(PasswordUtil.hashPassword(passwordInserita));
    }

    /**
     * Restituisce la data di nascita dell'utente
     * @return dataNascita data di nascita in formato YYYY-MM-DD
     */
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta la data di nascita dell'utente
     * @param dataNascita data di nascita dell'utente in formato YYYY-MM-DD
     */
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * Restituisce il domicilio dell'utente
     * @return domicilio il domicilio dell'utente
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Imposta il domicilio dell'utente
     * @param domicilio domicilio dell'utente
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Restituisce il ruolo dell'utente (cliente, proiezionista o bigliettaio)
     * @return ruolo ruolo utente
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * Imposta il ruolo dell'utente
     * @param ruolo ruolo dell'utente
     */
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * Restituisce l'età dell'utente calcolandola in automatico.
     * @return età l'età dell'utente
     */
    public int getEta() {
        return Period.between(dataNascita, LocalDate.now()).getYears();
    }

    /**

     * Restituisce una rappresentazione testuale dell'utente.
     * <p>La stringa contiene le principali informazioni dell'utente, tra cui nome, cognome, username, data di nascita, età,
     * domicilio e ruolo. </p>
     *
     * @return una stringa contenente i dati dell'utente
     */

    @Override
    public String toString() {
        return "model.Utente:\n" +
                "nome: " + nome + "\n" +
                "cognome: " + cognome + "\n" +
                "username: " + username + "\n" +
                "data di nascita: " + dataNascita.format(FORMATTER_DATA) + "\n" +
                "età: " + getEta() + "\n" +
                "domicilio: " + domicilio + "\n" +
                "ruolo: " + ruolo;
    }

}