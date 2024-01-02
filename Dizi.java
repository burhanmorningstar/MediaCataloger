import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dizi extends Medya {
    private static final String DİZİ_ADI = "diziler.txt";
    private static final String DİZİ_YORUM_ADI = "diziyorumlari.txt";

    // Parametreli constructor ile dizi bilgilerini alarak listeye ekleme yapan metot
    Dizi(String isim, int sezonSayisi, int bolumSayisi) {
        this.isim = isim;
        this.sezonSayisi = sezonSayisi;
        this.bolumSayisi = bolumSayisi;
        diziEkle(isim, sezonSayisi, bolumSayisi);
    }

    // Default constructor
    Dizi() {
    }

    // Dizi listesine kullanıcıdan girilen dizi bilgilerini ekleyen metod
    public void diziEkle(String isim, int sezonSayisi, int bolumSayisi) {
        Medya.dosyayaYaz(DİZİ_ADI, isim, sezonSayisi, bolumSayisi);
    }

    // Dizileri listelemek için dosyadan okuma yapan metod
    public void dizileriListele() {
        try (Scanner scanner = new Scanner(new File(DİZİ_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] parcalar = satir.split("\\|");

                if (parcalar.length == 3) {
                    String diziAdi = parcalar[0].trim();
                    sezonSayisi = Integer.parseInt(parcalar[1].trim());
                    bolumSayisi = Integer.parseInt(parcalar[2].trim());

                    System.out.println(diziAdi + " İsimli Dizinin " + sezonSayisi + " Sezonu Bulunmakta Ve Toplamda " + bolumSayisi + " Bölümü Bulunmakta\n");
                } else {
                    System.out.println("Hatalı Dosya Formatı: " + satir);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dizi Dosyası Bulunamadı.");
            e.printStackTrace();
        }
    }

    // Aranan dizi için yorumları gösteren metod
    public static void diziYorumlarınıGoster(String arananDizi) {
        try {
            Scanner sc = new Scanner(new File(DİZİ_YORUM_ADI));
            while (sc.hasNextLine()) {
                String satir = sc.nextLine();
                String[] satirElemanlari = satir.strip().split("\\|");
                if (satirElemanlari.length > 0 && satirElemanlari[0].strip().toLowerCase().equals(arananDizi.toLowerCase())) {
                    System.out.println(arananDizi + " İçin Yorumlar: " + satirElemanlari[1].strip());
                    return;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(DİZİ_YORUM_ADI + " Dosya Bulunamadı.");
        } catch (Exception e) {
            System.out.println("Bir Hata Oluştu: " + e.getMessage());
        }
    }
}
