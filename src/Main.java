import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("BENVENUTI IN CINEMAX!");
        System.out.println("SELEZIONARE IL TIPO DI UTENTE\n");
        System.out.println("Selezionare 1 per Guest");
        System.out.println("Selezionare 2 per Cliente Registrato");
        System.out.println("Selezionare 3 per Registrazione");
        System.out.println("Selezionare 4 per Proiezionista");
        System.out.println("Selezionare 5 per Bigliettaio");
        System.out.println("Selezionare 0 per uscire");


        while (true) {
            int sceltaUtente = scanner.nextInt();
            scanner.nextLine();

            switch (sceltaUtente) {
                case 1:
                    System.out.println("Accesso come Guest...");
                    break;

                case 2:
                    System.out.println("Accesso come Cliente Registrato...");
                    break;

                case 3:
                    System.out.println("Registrazione utente...");
                    break;

                case 4:
                    System.out.println("Accesso come Proiezionista...");
                    break;

                case 5:
                    System.out.println("Accesso come Biglietteria...");
                    break;

                case 0:
                    System.out.println("Uscita dal programma...");
                    break; // <-- esce dal main, quindi dal while

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    continue;
            }

            break; // esce dal while dopo una scelta valida
        }

        scanner.close();
    }
}
