class Film extends Medya {
    private String metraj;
    private int sure;

    // Constructor
    public Film(String isim, int vizyonYili, String yonetmen, String tur, String metraj, int sure) {
        super(isim, vizyonYili, yonetmen, tur);
        this.metraj = metraj;
        this.sure = sure;
    }

    // Getter methods specific to Film class
    public String getMetraj() {
        return metraj;
    }

    public int getSure() {
        return sure;
    }
}