
package model;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import repository.RepoUtenti;
import service.GestioneUtenti;
import Util.PasswordUtil;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RepoUtenti repoUtenti = new RepoUtenti();
        GestioneUtenti gestioneUtenti = new GestioneUtenti(repoUtenti);

        System.out.println("BENVENUTI IN CINEMAX!");
        System.out.println("SELEZIONARE UN'OPZIONE\n");
        System.out.println("Selezionare 1 per Guest");
        System.out.println("Selezionare 2 per Login");
        System.out.println("Selezionare 3 per Registrazione cliente");
        System.out.println("Selezionare 0 per uscire");

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Inserire un numero valido.");
                scanner.nextLine();
                continue;
            }

            int sceltaUtente = scanner.nextInt();
            scanner.nextLine();

            switch (sceltaUtente) {

                case 1:
                    System.out.println("Accesso come Guest...");
                    break;

                case 2:
                    System.out.println("Accesso come utente registrato...");

                    System.out.println("Inserire la mail");
                    String mail2 = scanner.nextLine();

                    // Ricerca dell'utente tramite mail
                    Utente utente = gestioneUtenti.cercaUtentePerMail(mail2);

                    // Controllo dell'esistenza dell'email
                    while (utente == null) {
                        System.out.println("Email non registrata. Inserisci nuovamente la mail:");
                        mail2 = scanner.nextLine();
                        utente = gestioneUtenti.cercaUtentePerMail(mail2);
                    }

                    // Richiesta della password
                    System.out.println("Inserire la password");
                    String password2 = scanner.nextLine();

                    // Controllo della password e gestione dei tentativi errati
                    while (!utente.verificaPassword(password2)) {
                        System.out.println("Password errata. Inserisci nuovamente la password:");
                        password2 = scanner.nextLine();
                    }

                    // Accesso all'area riservata in base al ruolo dell'utente
                    System.out.println("Ciao " + utente.getNome() + "!");

                    switch (utente.getRuolo()) {
                        case CLIENTE:
                            System.out.println("Accesso all'area clienti.");
                            break;

                        case PROIEZIONISTA:
                            System.out.println("Accesso all'area proiezionista.");
                            break;

                        case BIGLIETTAIO:
                            System.out.println("Accesso all'area biglietteria.");
                            break;

                        case ADMIN:
                            System.out.println("Accesso all'area amministrativa IT.");
                            break;
                    }

                    break;

                case 3:
                    System.out.println("Registrazione utente...");

                    System.out.println("Nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Cognome:");
                    String cognome = scanner.nextLine();

                    System.out.println("Mail:");
                    String mail3 = scanner.nextLine();

                    System.out.println("Username:");
                    String username = scanner.nextLine();

                    // Controllo della data di nascita
                    DateTimeFormatter formatter = DateTimeFormatter
                            .ofPattern("dd/MM/uuuu")
                            .withResolverStyle(ResolverStyle.STRICT);

                    LocalDate dataNascita3 = null;

                    while (dataNascita3 == null) {
                        System.out.println("Data di nascita (gg/MM/aaaa):");
                        String dataNascita = scanner.nextLine();

                        try {
                            LocalDate dataInserita =
                                    LocalDate.parse(dataNascita, formatter);

                            if (gestioneUtenti.verificaDataNascita(dataInserita)) {
                                dataNascita3 = dataInserita;
                            } else {
                                System.out.println("Data di nascita non valida. Riprova!");
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println(
                                    "Data non valida. Inserire una data nel formato gg/MM/aaaa.");
                        }
                    }

                    System.out.println("Domicilio:");
                    String domicilio = scanner.nextLine();

                    System.out.println("Password:");
                    String password3 = scanner.nextLine();

                    Utente nuovoUtente = new Utente(
                            nome,
                            cognome,
                            mail3,
                            username,
                            PasswordUtil.hashPassword(password3),
                            dataNascita3,
                            domicilio,
                            Ruolo.CLIENTE
                    );

                    // Controllo dei campi obbligatori
                    String campoMancante;

                    while ((campoMancante =
                            gestioneUtenti.verificaCampiObbligatori(nuovoUtente)) != null) {

                        System.out.println(
                                "Il campo " + campoMancante +
                                        " è obbligatorio. Inseriscilo nuovamente:");

                        switch (campoMancante) {

                            case "nome":
                                nome = scanner.nextLine();
                                nuovoUtente.setNome(nome);
                                break;

                            case "cognome":
                                cognome = scanner.nextLine();
                                nuovoUtente.setCognome(cognome);
                                break;

                            case "email":
                                mail3 = scanner.nextLine();
                                nuovoUtente.setEmail(mail3);
                                break;

                            case "username":
                                username = scanner.nextLine();
                                nuovoUtente.setUsername(username);
                                break;

                            case "domicilio":
                                domicilio = scanner.nextLine();
                                nuovoUtente.setDomicilio(domicilio);
                                break;

                            case "password":
                                password3 = scanner.nextLine();
                                nuovoUtente.setPassword(
                                        PasswordUtil.hashPassword(password3));
                                break;
                        }
                    }

                    // Controllo dello username duplicato
                    while (gestioneUtenti.cercaUtentePerUsername(
                            nuovoUtente.getUsername()) != null) {

                        System.out.println(
                                "Username già utilizzato. Inserisci un nuovo username:");
                        username = scanner.nextLine();
                        nuovoUtente.setUsername(username);
                    }

                    // Controllo dell'email duplicata
                    while (gestioneUtenti.cercaUtentePerMail(
                            nuovoUtente.getEmail()) != null) {

                        System.out.println(
                                "Email già utilizzata. Inserisci una nuova email:");
                        mail3 = scanner.nextLine();
                        nuovoUtente.setEmail(mail3);
                    }

                    // Controllo dei requisiti minimi della password
                    while (!gestioneUtenti.verificaPassword(password3)) {

                        System.out.println(
                                "La password non rispetta i requisiti minimi. Inserire una nuova password");
                        password3 = scanner.nextLine();

                        nuovoUtente.setPassword(
                                PasswordUtil.hashPassword(password3));
                    }

                    // Registrazione del nuovo cliente
                    boolean registrazioneRiuscita =
                            gestioneUtenti.registrazioneCliente(nuovoUtente);

                    if (registrazioneRiuscita) {
                        System.out.println("Registrazione completata!");
                    } else {
                        System.out.println("Registrazione non riuscita.");
                    }

                    break;

                case 0:
                    System.out.println("Uscita dal programma...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    continue;
            }
        }
    }
}
