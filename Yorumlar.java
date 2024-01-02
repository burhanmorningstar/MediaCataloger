import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Yorumlar extends Medya {
    private String yorum = null;
    private final String FİLM_YORUM_ADI = "yorumlar.txt";
    private final String DİZİ_YORUM_ADI = "diziyorumlari.txt";

    // Parametreli constructor ile film yorumu ekleyebilirsiniz.
    Yorumlar(String isim, String yorum) {
        this.isim = isim;
        this.yorum = yorum;
        filmYorumEkle(isim, yorum);
    }

    // Default constructor
    Yorumlar() {
    }

    // Belirtilen dosyaya film yorumunu ekleyen metod
    public void filmYorumEkle(String isim, String yorum) {
        dosyayaYaz(FİLM_YORUM_ADI, isim, yorum);
    }

    // Film yorumlarını listelemek için dosyadan okuma yapan metod
    public void filmYorumlariListele() {
        try (Scanner scanner = new Scanner(new File(FİLM_YORUM_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] parcalar = satir.split("\\|");

                if (parcalar.length == 2) {
                    String filmAdi = parcalar[0].trim();
                    String yorum = parcalar[1].trim();

                    System.out.println(filmAdi + " İsimli Film Hakkındaki Yorum:" + yorum + "\n");
                } else {
                    System.out.println("Hatalı Dosya Formatı: " + satir);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Yorum Dosyası Bulunamadı.");
            e.printStackTrace();
        }
    }

    // Dizi yorumu eklemek için kullanılan metod
    public void diziYorumEkle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dizi Adını Giriniz:");
        isim = sc.nextLine();
        System.out.println("Yorumunuzu Giriniz:");
        yorum = sc.nextLine();

        dosyayaYaz(isim, yorum);
    }

    // Dizi yorumlarını listelemek için dosyadan okuma yapan metod
    public void diziYorumlariListele() {
        try (Scanner scanner = new Scanner(new File(DİZİ_YORUM_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] parcalar = satir.split("\\|");

                if (parcalar.length == 2) {
                    String diziAdi = parcalar[0].trim();
                    String yorum = parcalar[1].trim();

                    System.out.println(diziAdi + " İsimli Dizi Hakkındaki Yorum: " + yorum + "\n");
                } else {
                    System.out.println("Hatalı Dosya Formatı: " + satir);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Yorum Dosyası Bulunamadı.");
            e.printStackTrace();
        }
    }

}
