import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Film extends TemelBilgi implements ElestiriArayuzu {
    private static final String DOSYA_ADI = "Filmler.txt";

    public void filmEkle() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Film adını giriniz:");
        String filmAdi = sc.nextLine();
        System.out.println("Yönetmeni giriniz:");
        String yonetmen = sc.nextLine();
        System.out.println("Yılını giriniz:");
        int yil = sc.nextInt();
        sc.nextLine();

        try (FileWriter writer = new FileWriter(DOSYA_ADI, true)) {
            writer.write(filmAdi + " | " + yonetmen + " | " + yil + "\n");
            System.out.println("Film başarıyla eklendi.");
        } catch (IOException e) {
            System.err.println("Film eklerken bir hata oluştu.");
            e.printStackTrace();
        }
    }

    public void filmleriListele() {

        try (Scanner scanner = new Scanner(new File(DOSYA_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                System.out.println(satir);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Film dosyası bulunamadı.");
            e.printStackTrace();
        }
    }

    public void yorumEkle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Film adını giriniz:");
        String filmAdi = sc.nextLine();
        System.out.println("Yorumunuzu giriniz:");
        String yorum = sc.nextLine();
        try (FileWriter writer = new FileWriter("Yorumlar.txt", true)) {
            writer.write(filmAdi + " | " + yorum + "\n");
            System.out.println("Yorum başarıyla eklendi.");
        } catch (IOException e) {
            System.err.println("Yorum eklerken bir hata oluştu.");
            e.printStackTrace();
        }
    }

    public void filmleriYorumlariylaListele() {
        try (Scanner filmScanner = new Scanner(new File(DOSYA_ADI));
             Scanner yorumScanner = new Scanner(new File("Yorumlar.txt"))) {

            while (filmScanner.hasNextLine()) {
                String filmSatir = filmScanner.nextLine();
                System.out.println("Film: " + filmSatir);

                while (yorumScanner.hasNextLine()) {
                    String yorumSatir = yorumScanner.nextLine();
                    String[] yorumBilgileri = yorumSatir.split(" \\| ");

                    if (yorumBilgileri.length == 2 && yorumBilgileri[0].equals(filmSatir.split(" \\| ")[0])) {
                        System.out.println("Yorum: " + yorumBilgileri[1]);
                    }
                }


            }
        } catch (FileNotFoundException e) {
            System.err.println("Film veya yorum dosyaları bulunamadı.");
            e.printStackTrace();
        }
    }
}
