**CINEMAX**

CINEMAX è un'applicazione Java per la gestione di un cinema monosala, sviluppata nell'ambito di un progetto universitario.

L'obiettivo è realizzare un sistema che permetta di gestire gli utenti e le attività principali di un cinema tra cui proiezioni, prenotazioni e vendita dei biglietti.

## Tecnologie utilizzate

- **Java 23** – linguaggio di programmazione
- **CSV** – archiviazione e persistenza dei dati
- **SHA-256** – hashing delle password
- **IntelliJ IDEA** – ambiente di sviluppo
- **Git e GitHub** – versionamento del codice

## Funzionalità implementate

### Gestione degli utenti
- Registrazione dei clienti.
- Controllo dei campi obbligatori.
- Validazione della data di nascita.
- Verifica dei requisiti di sicurezza delle password.
- Controllo di unicità di username e indirizzo email.
- Autenticazione tramite email e password.
- Gestione degli accessi in base al ruolo.
- Salvataggio e caricamento degli utenti tramite file CSV.
- Memorizzazione delle password sotto forma di hash SHA-256.

### Gestione dei ruoli

Il sistema prevede diverse tipologie di utenti:

- CLIENTE: utente che usufruisce dei servizi del cinema 
- PROIEZIONISTA: personale addetto alla gestione delle proiezioni 
- BIGLIETTAIO: personale addetto alla vendita dei biglietti 
- ADMIN: utente con privilegi amministrativi destinato alla gestione degli account del personale.

## Architettura del progetto

Il progetto è organizzato in package, con l'obiettivo di separare le responsabilità delle diverse componenti.

- `model`: definizione delle entità e dei ruoli
- `repository`: accesso ai dati e persistenza su CSV
- `service`: logica applicativa e validazione
- `Util`: funzioni di utilità tra cui hashing delle password
- `test`: classi di test

La classe Main rappresenta l'interfaccia con l'utente e accoglie gli input.

### Flusso applicativo

L'applicazione segue una struttura a livelli:

`Main → GestioneUtenti → RepoUtenti`

- **Main:** gestisce l'interazione con l'utente tramite console.
- **GestioneUtenti:** gestisce la logica applicativa e i controlli.
- **RepoUtenti:** si occupa del caricamento, della ricerca e del salvataggio degli utenti.

## Avvio del progetto

1. Clonare il repository:

```bash
git clone https://github.com/moonwhileloop/Cinemax.git
```

2. Aprire il progetto con IntelliJ IDEA.
3. Verificare che sia configurato JDK 23.
4. Controllare la presenza del file `data/utenti.csv`.
5. Avviare la classe `Main`.

## Test

Il progetto include classi di test dedicate alla verifica delle funzionalità di gestione degli utenti, tra cui:

- Ricerca degli utenti.
- Verifica delle password.
- Autenticazione con credenziali corrette.
- Gestione di password errate.
- Gestione di indirizzi mail inesistenti.

## Sviluppi futuri

Tra le funzionalità previste per le successive fasi di sviluppo:

- Registrazione e gestione degli account del personale da parte dell'amministratore.
- Gestione dei film e delle proiezioni da parte del personale.
- Gestione della disponibilità dei posti in sala.
- Prenotazione dei posti.
- Vendita e gestione dei biglietti.
- Ampliamento dei test delle funzionalità applicative.
- Introduzione di un database relazionale SQL e gestione della concorrenza.


**Progetto universitario del corso di laurea in informatica**

*Lo sviluppo di CINEMAX è in corso.*
