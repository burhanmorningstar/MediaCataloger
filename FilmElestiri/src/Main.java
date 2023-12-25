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
                secim1 ="h";
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
            System.out.println("Devam Etmek İstiyormusunuz E/H");
            secim1=sc.nextLine();
            break;
        default:
            System.out.println("Geçersiz seçim");
            break;
            
    }
    
   
}while (Objects.equals(secim1, "E") || Objects.equals(secim1, "e"));

    }
}