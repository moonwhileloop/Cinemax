package model;

/**
 * Rappresenta un film presente nel catalogo.
 * <p>
 *     Contiene tutte le informazioni necessarie per descrivere un film: titolo del film,
 *     genere, regista, anno di uscita, durata ed età minima consigliata per la visione.
 * </p>
 *
 * @author Martina Molteni
 * @version 1.0
 */

public class Film {
    private String titolo;
    private String genere;
    private String regista;
    private int anno;
    private int durata;
    private int etaMinima;

    /**
     * Crea un nuovo film inizializzando tutti gli attributi:
     *
     * @param titolo titolo del film
     * @param genere genere cinematografico del film
     * @param regista regista del film
     * @param anno anno di uscita del film
     * @param durata durata del film in minuti
     * @param etaMinima età minima consigliata per la visione
     */

    public Film(String titolo, String genere, String regista, int anno, int durata, int etaMinima) {
        this.titolo = titolo;
        this.genere = genere;
        this.regista = regista;
        this.anno = anno;
        this.durata = durata;
        this.etaMinima = etaMinima;
    }

    /**
     * Restituisce il titolo del film
      * @return il titolo del film
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * imposta il titolo del film
     * @param titolo nuovo titolo del film
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce il genere del film
     * @return il genere del film
     */

    public String getGenere() {
        return genere;
    }

    /**
     * imposta il genere del film
     * @param genere nuovo genere del film
     */

    public void setGenere(String genere) {
        this.genere = genere;
    }

    /**
     * Restituisce il regista del film
     * @return il genere del film
     */

    public String getRegista() {
        return regista;
    }

    /**
     * imposta il nuovo regista del film
     * @param regista nuovo regista del film
     */

    public void setRegista(String regista) {
        this.regista = regista;
    }

    /**
     * Restituisce l'anno di uscita del film
     * @return l'anno di uscita del film
     */

    public int getAnno() {
        return anno;
    }

    /**
     * Imposta l'anno di uscita del film
     * @param anno anno di uscita del film
     */

    public void setAnno(int anno) {
        this.anno = anno;
    }

    /**
     * Restituisce la durata in minuti del film
     * @return durata in minuti del film
     */

    public int getDurata() {
        return durata;
    }

    /**
     * Imposta la durata in minuti del film
     * @param durata durata in minuti del film
     */

    public void setDurata(int durata) {
        this.durata = durata;
    }

    /**
     * Restituisce l'età minima per poter vedere il film
     * @return età minima adatta alla visione del film
     */

    public int getEtaMinima() {
        return etaMinima;
    }

    /**
     * Imposta l'età minima adeguata alla visione del film
     * @param etaMinima imposta l'età minima
     */

    public void setEtaMinima(int etaMinima) {
        this.etaMinima = etaMinima;
    }

    /**
     * Stampa le specifiche del film
     * @return stringa contenente le informazioni del film
     */

    @Override
    public String toString() {
        return "model.Film: " +
                "titolo= '" + titolo + '\'' +
                ", genere= '" + genere + '\'' +
                ", regista= '" + regista + '\'' +
                ", anno= " + anno +
                ", durata (minuti)= " + durata +
                ", età minima richiesta= " + etaMinima;
    }

}




