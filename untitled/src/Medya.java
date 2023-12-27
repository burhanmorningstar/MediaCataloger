class Medya {
    private String isim;
    private int vizyonYili;
    private String yonetmen;
    private String tur;

    // Constructor
    public Medya(String isim, int vizyonYili, String yonetmen, String tur) {
        this.isim = isim;
        this.vizyonYili = vizyonYili;
        this.yonetmen = yonetmen;
        this.tur = tur;
    }

    // Getter methods
    public String getIsim() {
        return isim;
    }

    public int getVizyonYili() {
        return vizyonYili;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public String getTur() {
        return tur;
    }
}