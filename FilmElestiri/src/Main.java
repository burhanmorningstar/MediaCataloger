import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kullanici kullanici1 = new Kullanici();
        Scanner sc = new Scanner(System.in);
        String secim1 = null;

        do {
            System.out.print("Bunlardan birini seçiniz\n" + "1. Giriş yap\n" + "2. Kayıt Ol\n");
            int secim = sc.nextInt();
            sc.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Kullanıcı adınızı giriniz:");
                    String idGiris = sc.nextLine();
                    System.out.println("Şifrenizi giriniz:");
                    String parolaGiris = sc.nextLine();

                    if (kullanici1.girisYap(idGiris, parolaGiris)) {
                        System.out.println("Giriş başarılı");
                        secim1 = "H";
                    } else {
                        System.out.println("Giriş başarısız");
                    }
                    break;
                case 2:
                    System.out.println("Kullanıcı adınızı giriniz:");
                    String yeniId = sc.nextLine();
                    System.out.println("Şifrenizi giriniz:");
                    String yeniParola = sc.nextLine();

                    if (kullanici1.kayitOl(yeniId, yeniParola)) {
                        System.out.println("Kayıt başarılı");
                    } else {
                        System.out.println("Kayıt başarısız");
                    }
                    break;
                default:
                    System.out.println("Geçersiz seçim");
                    break;
            }

        } while (Objects.equals(secim1, "E") || Objects.equals(secim1, "e"));

        if (Objects.equals(secim1, "H") || Objects.equals(secim1, "h")) {
            do {
                System.out.println("1. Film Ekle");
                System.out.println("2. Filmleri Listele");
                System.out.println("3. Yorum Ekle");
                System.out.println("4. Filmleri Yorumlarıyla Listele");

                int filmSecim = sc.nextInt();
                sc.nextLine();
                Film film = new Film();
                switch (filmSecim) {
                    case 1:
                        film.filmEkle();
                        break;
                    case 2:
                        film.filmleriListele();
                        break;
                    case 3:
                        film.yorumEkle();
                        break;
                    case 4:
                        film.filmleriYorumlariylaListele();
                        break;
                    default:
                        System.out.println("Geçersiz seçim");
                        break;
                }

                System.out.println("Devam Etmek İstiyormusunuz E/H");
                secim1 = sc.nextLine();
            } while (Objects.equals(secim1, "E") || Objects.equals(secim1, "e"));
        }
    }
}
