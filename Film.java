import java.io.*;
import java.util.Scanner;

public class Film extends Medya {
    private static final String FİLM_ADI = "Filmler.txt";
    private static final String FİLM_YORUM_ADI = "yorumlar.txt";

    // Parametreli constructor ile film bilgilerini alarak listeye ekleyen metot
    Film(String isim, String yonetmen, int cikisYili) {
        this.isim = isim;
        this.yonetmen = yonetmen;
        this.cikisYili = cikisYili;
        filmEkle(isim, yonetmen, cikisYili);
    }

    // Default constructor
    Film() {
    }

    // Film bilgilerini ekleyen metod
    public void filmEkle(String isim, String yonetmen, int cikisYili) {
        Medya.dosyayaYaz(FİLM_ADI, isim, yonetmen, cikisYili);
    }

    // Bütün filmleri listelemek için dosyadan okuma yapan metod
    public void filmleriListele() {
        try (Scanner scanner = new Scanner(new File("filmler.txt"))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] parcalar = satir.split("\\|");

                if (parcalar.length == 3) {
                    String filmAdi = parcalar[0].trim();
                    String yonetmenAdi = parcalar[1].trim();
                    int vizyonYili = Integer.parseInt(parcalar[2].trim());

                    System.out.println(yonetmenAdi + " İsimli Yönetmen Tarafından Yapılan " + filmAdi + " Filmi " + vizyonYili + " Yılında vizyona çıkmıştır\n");
                } else {
                    System.out.println("Hatalı Dosya Formatı: " + satir);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Film Dosyası Bulunamadı.");
            e.printStackTrace();
        }
    }

    // Aranan film için yorumları gösteren metod
    public static void filmYorumlarınıGoster(String arananFilm) {
        try {
            Scanner sc = new Scanner(new File(FİLM_YORUM_ADI));
            while (sc.hasNextLine()) {
                String satir = sc.nextLine();
                String[] satirElemanlari = satir.strip().split("\\|");
                if (satirElemanlari.length > 0 && satirElemanlari[0].strip().toLowerCase().equals(arananFilm.toLowerCase())) {
                    System.out.println(arananFilm + " İçin Yorumlar: " + satirElemanlari[1].strip());
                    return;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(FİLM_YORUM_ADI + " Dosya Bulunamadı.");
        } catch (Exception e) {
            System.out.println("Bir Hata Oluştu: " + e.getMessage());
        }
    }
}
