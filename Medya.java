import java.io.FileWriter;
import java.io.IOException;

// Medya sınıfı, film ve dizi sınıflarının ortak özelliklerini içerir ve abstract bir temel sınıftır.
public abstract class Medya {
    // Medya özellikleri
    protected String isim;
    protected String yonetmen;
    protected int cikisYili;
    protected int sezonSayisi;
    protected int bolumSayisi;

    // Belirtilen dosyaya film bilgilerini ekleyen statik metod
    protected static void dosyayaYaz(String dosyaAdi, String isim, String yonetmen, int yil) {
        try (FileWriter writer = new FileWriter(dosyaAdi, true)) {
            writer.write(isim + " | " + yonetmen + " | " + yil + "\n");
            System.out.println("Film Başarıyla Eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya Yazma İşleminde Bir Hata Oluştu.");
            e.printStackTrace();
        }
    }

    // Belirtilen dosyaya dizi bilgilerini ekleyen statik metod
    protected static void dosyayaYaz(String dosyaAdi, String isim, int sezonSayisi, int bolumSayisi) {
        try (FileWriter writer = new FileWriter(dosyaAdi, true)) {
            writer.write(isim + " | " + sezonSayisi + " | " + bolumSayisi + "\n");
            System.out.println("Dizi Başarıyla Eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya Yazma İşleminde Bir Hata Oluştu.");
            e.printStackTrace();
        }
    }

    // Belirtilen dosyaya yorum bilgilerini ekleyen statik metod
    protected static void dosyayaYaz(String dosyaAdi, String isim, String yorum) {
        try (FileWriter writer = new FileWriter(dosyaAdi, true)) {
            writer.write(isim + " | " + yorum + "\n");
            System.out.println("Yorum Başarıyla Eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya Yazma İşleminde Bir Hata Oluştu.");
            e.printStackTrace();
        }
    }
    // Belirtilen dosyaya yorum bilgilerini ekleyen statik metod
    protected static void dosyayaYaz(String isim, String yorum) {
        try (FileWriter writer = new FileWriter("diziyorumlari.txt", true)) {
            writer.write(isim + " | " + yorum + "\n");
            System.out.println("Yorum Başarıyla Eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya Yazma İşleminde Bir Hata Oluştu.");
            e.printStackTrace();
        }
    }
}
