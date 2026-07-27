public class Film {
    private String titolo;
    private String genere;
    private String regista;
    private int anno;
    private int durata;
    private int etaMinima;

    public Film(String titolo, String genere, String regista, int anno, int durata, int etaMinima) {
        this.titolo = titolo;
        this.genere = genere;
        this.regista = regista;
        this.anno = anno;
        this.durata = durata;
        this.etaMinima = etaMinima;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(int etaMinima) {
        this.etaMinima = etaMinima;
    }

    @Override
    public String toString() {
        return "Film: " +
                "titolo= '" + titolo + '\'' +
                ", genere= '" + genere + '\'' +
                ", regista= '" + regista + '\'' +
                ", anno= " + anno +
                ", durata (minuti)= " + durata +
                ", età minima richiesta= " + etaMinima;
    }

}




