
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import java.util.ArrayList;
import java.util.List;

import model.Ruolo;
import model.Utente;

/**
 * Repository responsabile della gestione e della persistenza
 * dei dati degli utenti del sistema CINEMAX.
 *
 * <p>La classe gestisce una lista di oggetti {@link Utente},
 * caricando inizialmente i dati dal file CSV e consentendo
 * successivamente di ricercare e registrare nuovi utenti.</p>
 *
 * <p>Le operazioni di lettura e scrittura vengono effettuate
 * attraverso il file {@code utenti.csv}, che rappresenta
 * l'archivio persistente degli utenti.</p>
 */
public class RepoUtenti {

    private final List<Utente> utenti;
    private static final String FILE_UTENTI = "Cinemax/data/utenti.csv";

    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    /**
     * Costruisce una nuova repository degli utenti.
     *
     * <p>Inizializza la lista degli utenti e carica i dati
     * presenti nel file CSV attraverso il metodo
     * {@link #caricaUtenti()}.</p>
     */
    public RepoUtenti() {
        utenti = new ArrayList<>();
        caricaUtenti();
    }

    /**
     * Carica gli utenti dal file CSV e li inserisce nella lista interna.
     *
     * <p>Il metodo legge il file, salta la riga di intestazione
     * e converte i dati di ciascun record nei rispettivi tipi.
     * In particolare, la data di nascita viene convertita in
     * {@link LocalDate} e il ruolo viene convertito nel
     * corrispondente valore dell'enum {@link Ruolo}.</p>
     *
     * <p>Per ogni riga valida viene creato un oggetto {@link Utente},
     * successivamente aggiunto alla lista interna.</p>
     *
     * <p>In caso di errore durante la lettura del file,
     * viene stampato un messaggio di errore a console.</p>
     */
    private void caricaUtenti() {

        File file = new File(FILE_UTENTI);

        if (!file.exists()) {
            System.out.println("File utenti non trovato.");
            return;
        }

        try (BufferedReader brUtenti = new BufferedReader(new FileReader(file))) {

            String rigaUtente;

            // Salta l'intestazione
            brUtenti.readLine();

            while ((rigaUtente = brUtenti.readLine()) != null) {

                // Divide la riga in base al separatore ;
                String[] dati = rigaUtente.split(";", -1);

                if (dati.length != 8) {
                    System.out.println("Riga non valida nel file utenti: " + rigaUtente);
                    continue;
                }

                // Verifica che tutti i campi siano valorizzati
                boolean campiValidi = true;

                for (String campo : dati) {
                    if (campo.isBlank()) {
                        campiValidi = false;
                        break;
                    }
                }

                if (!campiValidi) {
                    System.out.println("Campi mancanti nella riga: " + rigaUtente);
                    continue;
                }

                // Converte la data da String a LocalDate
                LocalDate dataNascita;

                try {
                    dataNascita = LocalDate.parse(dati[5], FORMATO_DATA);

                } catch (DateTimeParseException e) {
                    System.out.println("Data di nascita non valida nella riga: " + rigaUtente);
                    continue;
                }

                // Converte il testo in un valore dell'enum Ruolo
                Ruolo ruolo;

                try {
                    ruolo = Ruolo.valueOf(dati[7]);

                } catch (IllegalArgumentException e) {
                    System.out.println("Ruolo non valido nella riga: " + rigaUtente);
                    continue;
                }

                // Crea l'oggetto Utente
                Utente utente = new Utente(
                        dati[0],
                        dati[1],
                        dati[2],
                        dati[3],
                        dati[4],
                        dataNascita,
                        dati[6],
                        ruolo
                );

                // Verifica che username ed email non siano duplicati
                if (cercaPerUsername(utente.getUsername()) != null
                        || cercaPerMail(utente.getEmail()) != null) {

                    System.out.println("Utente duplicato nella riga: " + rigaUtente);
                    continue;
                }

                // Aggiunge l'utente alla lista
                utenti.add(utente);
            }

        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file utenti.");
        }
    }

    /**
     * Restituisce una copia della lista degli utenti presenti nella repository.
     *
     * <p>Viene restituita una nuova lista contenente gli stessi oggetti
     * {@link Utente}, in modo da impedire modifiche dirette alla lista
     * interna della repository.</p>
     *
     * @return copia della lista degli utenti
     */
    public List<Utente> getUtenti() {
        return new ArrayList<>(utenti);
    }

    /**
     * Cerca un utente nella repository tramite username.
     *
     * <p>Il metodo scorre la lista degli utenti e confronta
     * lo username fornito con quello associato a ciascun utente.</p>
     *
     * @param username username dell'utente da ricercare
     * @return l'oggetto {@link Utente} corrispondente se presente,
     *         {@code null} altrimenti
     */
    public Utente cercaPerUsername(String username) {

        if (username == null || username.isBlank()) {
            return null;
        }

        for (Utente utente : utenti) {

            if (utente.getUsername().equals(username)) {
                return utente;
            }
        }

        return null;
    }

    /**
     * Registra un nuovo utente nella repository.
     *
     * <p>Prima di procedere con la registrazione, verifica che
     * lo username e l'indirizzo email non siano già associati
     * ad altri utenti.</p>
     *
     * <p>Se i controlli vengono superati, delega il salvataggio
     * dei dati al metodo {@link #salvaUtente(Utente)}.
     * L'utente viene aggiunto alla lista interna solamente
     * se il salvataggio sul file CSV avviene correttamente.</p>
     *
     * @param utente utente da registrare
     * @return {@code true} se la registrazione è avvenuta con successo,
     *         {@code false} se username o email sono già utilizzati
     *         oppure se il salvataggio non è riuscito
     */
    public boolean aggiungiUtente(Utente utente) {

        if (utente == null) {
            return false;
        }

        if (cercaPerUsername(utente.getUsername()) != null) {
            return false;
        }

        if (cercaPerMail(utente.getEmail()) != null) {
            return false;
        }

        // Salva l'utente nel CSV
        if (!salvaUtente(utente)) {
            return false;
        }

        // Aggiunge l'utente alla lista solo se il salvataggio è riuscito
        utenti.add(utente);

        System.out.println("Utente registrato correttamente");
        return true;
    }

    /**
     * Salva i dati di un nuovo utente nel file CSV.
     *
     * <p>Il metodo apre il file in modalità append, in modo da
     * aggiungere i dati senza sovrascrivere i record esistenti.
     * La data di nascita viene formattata secondo il modello
     * {@code dd/MM/uuuu}.</p>
     *
     * <p>I dati dell'utente vengono scritti su una nuova riga,
     * utilizzando il punto e virgola come separatore dei campi.
     * Viene salvato l'hash della password anziché la password
     * in chiaro.</p>
     *
     * @param utente utente di cui salvare i dati
     * @return {@code true} se il salvataggio è avvenuto correttamente,
     *         {@code false} in caso di errore durante la scrittura
     */
    private boolean salvaUtente(Utente utente) {

        File file = new File(FILE_UTENTI);

        if (utente == null || utente.getDataNascita() == null) {
            return false;
        }

        try {

            // Controlla se il file termina già con una nuova riga
            if (file.exists() && file.length() > 0) {

                try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {

                    raf.seek(file.length() - 1);
                    int ultimoCarattere = raf.read();

                    if (ultimoCarattere != '\n' && ultimoCarattere != '\r') {

                        try (BufferedWriter separatore =
                                     new BufferedWriter(new FileWriter(file, true))) {

                            separatore.newLine();
                        }
                    }
                }
            }

            // Aggiunge il nuovo utente
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

                bw.write(
                        utente.getNome() + ";" +
                                utente.getCognome() + ";" +
                                utente.getEmail() + ";" +
                                utente.getUsername() + ";" +
                                utente.getPasswordHash() + ";" +
                                utente.getDataNascita().format(FORMATO_DATA) + ";" +
                                utente.getDomicilio() + ";" +
                                utente.getRuolo()
                );

                bw.newLine();
                return true;
            }

        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dell'utente.");
            return false;
        }
    }

    /**
     * Cerca un utente registrato tramite il suo indirizzo email.
     *
     * @param mail indirizzo email dell'utente da cercare
     * @return l'oggetto Utente corrispondente all'email,
     *         oppure null se nessun utente è stato trovato
     */
    public Utente cercaPerMail(String mail) {

        if (mail == null || mail.isBlank()) {
            return null;
        }

        for (Utente utente : utenti) {

            if (utente.getEmail().equals(mail)) {
                return utente;
            }
        }

        return null;
    }
}
