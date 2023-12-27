class Dizi extends Medya {
    private int sezonSayisi;
    private int bolumSayisi;

    // Constructor
    public Dizi(String isim, int vizyonYili, String yonetmen, String tur, int sezonSayisi, int bolumSayisi) {
        super(isim, vizyonYili, yonetmen, tur);
        this.sezonSayisi = sezonSayisi;
        this.bolumSayisi = bolumSayisi;
    }

    // Getter methods specific to Dizi class
    public int getSezonSayisi() {
        return sezonSayisi;
    }

    public int getBolumSayisi() {
        return bolumSayisi;
    }
}