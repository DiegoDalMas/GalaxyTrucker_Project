public class Astronave {
    private String nome;
    private int struttura;
    private int velocita;
    private int capacitaCarico;
    private int carico;
    private int danni;

    // Costruttore
    public Astronave(String nome, int struttura, int velocita, int capacitaCarico) {
        this.nome = nome;
        this.struttura = struttura;
        this.velocita = velocita;
        this.capacitaCarico = capacitaCarico;
        this.carico = 0;
        this.danni = 0;
    }

    // Metodo per caricare l'astronave
    public void carica(int quantita) {
        if (carico + quantita <= capacitaCarico) {
            carico += quantita;
            System.out.println(nome + ": Carico aggiunto. Carico attuale: " + carico);
        } else {
            System.out.println(nome + ": Capacità di carico superata!");
        }
    }

    // Metodo per subire danni
    public void subisciDanno(int danno) {
        danni += danno;
        struttura -= danno;
        if (struttura <= 0) {
            System.out.println(nome + ": Astronave distrutta!");
        } else {
            System.out.println(nome + ": Subito " + danno + " danni. Struttura residua: " + struttura);
        }
    }

    // Metodo per riparare l'astronave
    public void ripara(int quantita) {
        struttura += quantita;
        System.out.println(nome + ": Riparata di " + quantita + ". Struttura attuale: " + struttura);
    }

    // Metodo per il volo
    public void volo() {
        if (struttura > 0) {
            System.out.println(nome + ": In volo con velocità " + velocita + " km/h.");
        } else {
            System.out.println(nome + ": Impossibile volare, astronave distrutta!");
        }
    }

    // Metodo per visualizzare lo stato dell'astronave
    public void stato() {
        System.out.println(nome + ": Struttura " + struttura + ", Carico " + carico + "/" + capacitaCarico + ", Danni " + danni);
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Getter per la velocità
    public int getVelocita() {
        return velocita;
    }

    // Getter per la capacità di carico
    public int getCapacitaCarico() {
        return capacitaCarico;
    }
}
