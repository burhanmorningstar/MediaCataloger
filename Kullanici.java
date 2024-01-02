import java.io.*;
import java.util.*;

class GecersizSecimException extends Exception {
    public GecersizSecimException() {
        super("Geçersiz Seçim. Lütfen 1 Veya 2 Girin.");
    }
}

public class Kullanici {
    private String id;
    private String parola;
    private static final String DOSYA_ADI = "kullanicilar.txt";

    // Parametreli constructor ile kullanıcı oluşturma
    Kullanici(String id, String parola) {
        this.id = id;
        this.parola = parola;
    }

    // Default constructor
    Kullanici() {
    }

    // Ana menüyü gösteren metot
    public static void anaMenuEkrani() {
        String devamSecim = "e";
        Scanner sc = new Scanner(System.in);
        Yorumlar yorumlar = new Yorumlar();
        Dizi dizi = new Dizi();
        Film film = new Film();
        do {
            try {
                // Menü seçeneklerini göster
                System.out.println("--------------------------------------------");
                System.out.println("Menü");
                System.out.println("1. Film Ekle");
                System.out.println("2. Filmleri Listele");
                System.out.println("3. Film Yorumu Ekle");
                System.out.println("4. Film Yorumlarını Listele");
                System.out.println("5. Dizi Ekle");
                System.out.println("6. Dizileri Listele");
                System.out.println("7. Dizi Yorumu Ekle");
                System.out.println("8. Dizi Yorumlarını Listele");
                System.out.println("9. Aradığınız Filmin Yorumlarını Listele");
                System.out.println("10. Aradığınız Dizinin Yorumlarını Listele");
                System.out.println("11. Profil Bilgilerini Düzenle");

                int filmSecim = -1;
                // Kullanıcının geçerli bir seçim yapana kadar döngü
                while (filmSecim < 1 || filmSecim > 11) {
                    try {
                        System.out.print("Birini Seçiniz (1-11): ");
                        filmSecim = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Lütfen Geçerli Bir Tamsayı Girin.");
                        sc.nextLine();
                    }

                    if (filmSecim < 1 || filmSecim > 11) {
                        System.out.println("Geçersiz Bir Seçim Yaptınız. Lütfen 1 İle 11 Arasında Bir Değer Girin.");
                    }
                }

                // Kullanıcının seçimine göre işlemleri gerçekleştir
                switch (filmSecim) {
                    case 1:
                        System.out.println("Film Adını Giriniz:");
                        String isim = sc.nextLine();
                        System.out.println("Yönetmeni Giriniz:");
                        String yonetmen = sc.nextLine();
                        System.out.println("Yılını Giriniz:");
                        int cikisYili = sc.nextInt();
                        sc.nextLine();
                        Film film1 = new Film(isim, yonetmen, cikisYili);
                        break;
                    case 2:
                        film.filmleriListele();
                        break;
                    case 3:
                        System.out.println("Film Adını Giriniz:");
                        isim = sc.nextLine();
                        System.out.println("Yorumunuzu Giriniz:");
                        String yorum = sc.nextLine();
                        Yorumlar yorumlar1 = new Yorumlar(isim, yorum);
                        break;
                    case 4:
                        yorumlar.filmYorumlariListele();
                        break;
                    case 5:
                        System.out.println("Dizi Adını Giriniz:");
                        isim = sc.nextLine();
                        System.out.println("Sezon Sayısı Giriniz:");
                        int sezonSayisi = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Bölüm Sayısını Giriniz:");
                        int bolumSayisi = sc.nextInt();
                        sc.nextLine();
                        Dizi dizi1 = new Dizi(isim, sezonSayisi, bolumSayisi);
                        break;
                    case 6:
                        dizi.dizileriListele();
                        break;
                    case 7:
                        yorumlar.diziYorumEkle();
                        break;
                    case 8:
                        yorumlar.diziYorumlariListele();
                        break;
                    case 9:
                        System.out.println("Yorumlarını Görmek İstediğiniz Filmi Giriniz:");
                        String arananFilm = sc.nextLine();
                        Film.filmYorumlarınıGoster(arananFilm);
                        break;
                    case 10:
                        System.out.println("Yorumlarını Görmek İstediğiniz Diziyi Giriniz:");
                        String arananDizi = sc.nextLine();
                        Dizi.diziYorumlarınıGoster(arananDizi);
                        break;
                    case 11:
                        Kullanici.ProfilBilgisi.profilBilgisiDuzenleme();
                        break;
                    default:
                        System.out.println("Geçersiz Seçim");
                        break;
                }

            } catch (NoSuchElementException e) {
                System.err.println("Giriş alınamadı. Program sonlandırılıyor.");
                break;
            } catch (Exception e) {
                System.err.println("Bir hata oluştu: " + e.getMessage());
            }

            System.out.print("Devam Etmek İstiyormusunuz E/H: ");
            devamSecim = sc.nextLine();

        } while (Objects.equals(devamSecim, "E") || Objects.equals(devamSecim, "e"));
    }

    // Giriş ekranını gösteren metot
    public static void girisEkrani() {
        String devamSecim = "e";
        Scanner sc = new Scanner(System.in);
        do {
            try {
                // Giriş menüsünü göster
                System.out.println("Bunlardan Birini Seçiniz:");
                System.out.println("1. Giriş yap");
                System.out.println("2. Kayıt Ol");

                while (!sc.hasNextInt()) {
                    System.out.println("Lütfen Geçerli Bir Tamsayı Girin.");
                    sc.next();
                    devamSecim = "e";
                }

                int girisSecim = sc.nextInt();
                sc.nextLine();

                if (girisSecim != 1 && girisSecim != 2) {
                    throw new GecersizSecimException();
                }
                switch (girisSecim) {
                    case 1:
                        System.out.println("Kullanıcı Adınızı Giriniz:");
                        String idGiris = sc.nextLine();
                        System.out.println("Şifrenizi Giriniz:");
                        String parolaGiris = sc.nextLine();
                        Kullanici kullanici1 = new Kullanici(idGiris, parolaGiris);
                        if (kullanici1.girisYap()) {
                            System.out.println("Giriş Başarılı");
                            devamSecim = "H";
                        } else {
                            System.out.println("Giriş Başarısız");
                        }
                        break;
                    case 2:
                        System.out.println("Kullanıcı Adınızı Giriniz:");
                        String yeniId = sc.nextLine();
                        System.out.println("Şifrenizi Giriniz:");
                        String Parola = sc.nextLine();
                        Kullanici kullanici2 = new Kullanici();
                        if (kullanici2.kayitOl(yeniId, Parola)) {
                            System.out.println("Kayıt Başarılı");
                        } else {
                            System.out.println("Kayıt Başarısız");
                            devamSecim = "e";
                        }
                        break;
                    default:
                        System.out.println("Geçersiz Seçim");
                        System.out.println("Tekrar Deneyin");
                        devamSecim = "e";
                        break;

                }
            } catch (GecersizSecimException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Bir Hata Oluştu: " + e.getMessage());
            }
        } while (Objects.equals(devamSecim, "E") || Objects.equals(devamSecim, "e"));
    }

    // Kullanıcı girişini yapan metot
    public boolean girisYap() {
        try (Scanner scanner = new Scanner(new File(DOSYA_ADI))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] bilgiler = satir.split(" \\| ");
                if (bilgiler.length == 2 && bilgiler[0].equals(this.id) && bilgiler[1].equals(this.parola)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Kullanıcı Dosyası Bulunamadı.");
            e.printStackTrace();
        }
        return false;
    }

    // Kullanıcı kaydını yapan metot
    public boolean kayitOl(String id, String parola) {
        try {
            if (id.contains(" ") || parola.contains(" ")) {
                throw new YanlisGirdiHatasi("Kullanıcı Adı Veya Parola Boşluk İçeremez.");
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(DOSYA_ADI, true))) {
                writer.println(id + " | " + parola);
                this.id = id;
                this.parola = parola;
                return true;
            }
        } catch (IOException e) {
            System.err.println("Kayıt Sırasında Bir Hata Oluştu.");
            e.printStackTrace();
            return false;
        } catch (YanlisGirdiHatasi e) {
            System.err.println("Hata: " + e.getMessage());
            return false;
        }
    }
//Kullanıcı verilerini düzenlememiz için içinde metotlar olan iç içe sınıf
    public static class ProfilBilgisi {
        // Kullanıcı verilerini okuyup bir map'e atayan metot
        public static Map<String, String> kullaniciVerileriniOku() {
            Map<String, String> kullaniciVerileri = new HashMap<>();

            try (Scanner scanner = new Scanner(new File(DOSYA_ADI))) {
                while (scanner.hasNextLine()) {
                    String satir = scanner.nextLine();
                    String[] bilgiler = satir.split(" \\| ");

                    if (bilgiler.length == 2) {
                        kullaniciVerileri.put(bilgiler[0], bilgiler[1]);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return kullaniciVerileri;
        }
        //Kullanıcıdan alınan verileri dosyaya yazdıran metot
        public static void kullaniciVerileriniYaz(Map<String, String> kullaniciVerileri) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(DOSYA_ADI))) {

                for (Map.Entry<String, String> entry : kullaniciVerileri.entrySet()) {
                    writer.println(entry.getKey() + " | " + entry.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Profil bilgilerini düzenleyen metot
        public static void profilBilgisiDuzenleme() {
            Scanner sc = new Scanner(System.in);
            Map<String, String> kullaniciBilgileri = Kullanici.ProfilBilgisi.kullaniciVerileriniOku();
            System.out.print("Yeni Kullanıcı Adı: ");
            String yeniKullaniciAdi = sc.nextLine();
            System.out.print("Yeni Parola: ");
            String yeniParola = sc.nextLine();

            kullaniciBilgileri.put(yeniKullaniciAdi, yeniParola);
            Kullanici.ProfilBilgisi.kullaniciVerileriniYaz(kullaniciBilgileri);

            System.out.println("Kullanıcı Bilgileri Başarıyla Güncellendi.");
        }
    }

    // Özel bir hata sınıfı
    class YanlisGirdiHatasi extends Exception {
        public YanlisGirdiHatasi(String message) {
            super(message);
        }
    }
}
