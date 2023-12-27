import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class Kullanici extends TemelBilgi implements ElestiriArayuzu {
    class ProfilBilgisi{

    }
    private static final String DOSYA_ADI = "kullanicilar.txt";

    public boolean girisYap(String id, String parola) {
        try (Scanner scanner = new Scanner(new File(DOSYA_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] bilgiler = satir.split(" ");
                if (bilgiler.length == 2 && bilgiler[0].equals(id) && bilgiler[1].equals(parola)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Kullanıcı dosyası bulunamadı.");
            e.printStackTrace();
        }
        return false;
    }


    public boolean kayitOl(String id, String parola) {
        try (FileWriter writer = new FileWriter(DOSYA_ADI, true)) {
            writer.write(id + " " + parola + "\n");
            return true;
        } catch (IOException e) {
            System.err.println("Kayıt sırasında bir hata oluştu.");
            e.printStackTrace();
            return false;
        }
    }
}