import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class Kullanici {
    private static final String DOSYA = "kullanicilar.txt";

    public boolean girisYap(String id, String parola) {
        try (Scanner sc1 = new Scanner(new File(DOSYA))) {
            while (sc1.hasNextLine()) {
                String satir = sc1.nextLine();
                String[] bilgiler = satir.split(" ");
                if (bilgiler.length == 2 && bilgiler[0].equals(id) && bilgiler[1].equals(parola)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Kayıtlı kullanıcı bulunamadı!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean kayitOl(String id, String parola) {
        try {
            if (id.contains(" ") || parola.contains(" ")) {
                throw new yanlisGirdiHatasi("Kullanıcı adı veya parola boşluk içeremez.");
            }

            try (FileWriter writer = new FileWriter(DOSYA, true)) {
                writer.write(id + " " + parola + "\n");
                return true;
            }
        } catch (IOException e) {
            System.err.println("Kayıt sırasında bir hata oluştu.");
            e.printStackTrace();
            return false;
        } catch (yanlisGirdiHatasi e) {
            System.err.println("Hata: " + e.getMessage());
            return false;
        }
    }
    class yanlisGirdiHatasi extends Exception {
        public yanlisGirdiHatasi(String message) {
            super(message);
        }
    }
}
