import java.util.Objects;
import java.util.Scanner;

class GecersizSecimException extends Exception {
    public GecersizSecimException() {
        super("Geçersiz seçim. Lütfen 1 veya 2 girin.");
    }
}

public class Main {
    public static void main(String[] args) {
        Kullanici kullanici1 = new Kullanici();
        Scanner sc = new Scanner(System.in);
        String secim1 = null;

        do {
            try {
                System.out.print("Bunlardan birini seçiniz\n" + "1. Giriş yap\n" + "2. Kayıt Ol\n");

                while (!sc.hasNextInt()) {
                    System.out.println("Lütfen geçerli bir tamsayı girin.");
                    sc.next();
                }

                int secim = sc.nextInt();
                sc.nextLine();

                if (secim != 1 && secim != 2) {
                    throw new GecersizSecimException();
                }

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
            } catch (GecersizSecimException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bir hata oluştu: " + e.getMessage());
            }

            System.out.println("Devam Etmek İstiyor musunuz E/H");
            secim1 = sc.nextLine();

        } while (Objects.equals(secim1, "E") || Objects.equals(secim1, "e"));
    }
}
