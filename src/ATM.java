import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    // Kullanıcı adı ve şifreye karşılık gelen bakiyeleri saklar
    private static final Map<String, String> kullaniciSifreleri = new HashMap<>();
    private static final Map<String, Double> kullaniciBakiyeleri = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Örnek kullanıcılar
        kullaniciSifreleri.put("denis", "1234");
        kullaniciSifreleri.put("güli", "5678");

        kullaniciBakiyeleri.put("denis", 1000.0);
        kullaniciBakiyeleri.put("güli", 500.0);

        System.out.println("🏦 ATM Sistemine Hoş Geldiniz");

        System.out.print("Kullanıcı adınızı girin: ");
        String kullaniciAdi = scanner.nextLine();

        System.out.print("Şifrenizi girin: ");
        String sifre = scanner.nextLine();

        if (kullaniciSifreleri.containsKey(kullaniciAdi) &&
                kullaniciSifreleri.get(kullaniciAdi).equals(sifre)) {

            System.out.println("✅ Giriş başarılı. Hoş geldiniz, " + kullaniciAdi + "!\n");
            double bakiye = kullaniciBakiyeleri.get(kullaniciAdi);
            int secim;

            do {
                System.out.println("1. Bakiye Görüntüle");
                System.out.println("2. Para Yatır");
                System.out.println("3. Para Çek");
                System.out.println("4. Çıkış");
                System.out.print("Bir işlem seçin: ");
                secim = scanner.nextInt();

                switch (secim) {
                    case 1:
                        System.out.println("💰 Mevcut Bakiye: " + bakiye + " TL\n");
                        break;
                    case 2:
                        System.out.print("Yatırmak istediğiniz miktarı girin: ");
                        double yatirilan = scanner.nextDouble();
                        if (yatirilan > 0) {
                            bakiye += yatirilan;
                            System.out.println("✅ Para yatırıldı. Yeni bakiye: " + bakiye + " TL\n");
                        } else {
                            System.out.println("⚠️ Geçersiz miktar!\n");
                        }
                        break;
                    case 3:
                        System.out.print("Çekmek istediğiniz miktarı girin: ");
                        double cekilecek = scanner.nextDouble();
                        if (cekilecek > 0 && cekilecek <= bakiye) {
                            bakiye -= cekilecek;
                            System.out.println("✅ Para çekildi. Yeni bakiye: " + bakiye + " TL\n");
                        } else {
                            System.out.println("⚠️ Yetersiz bakiye veya geçersiz miktar!\n");
                        }
                        break;
                    case 4:
                        System.out.println("👋 Çıkış yapılıyor. İyi günler!\n");
                        break;
                    default:
                        System.out.println("⚠️ Geçersiz seçim!\n");
                }
            } while (secim != 4);

            // Güncellenmiş bakiyeyi kaydet
            kullaniciBakiyeleri.put(kullaniciAdi, bakiye);
        } else {
            System.out.println("❌ Giriş başarısız! Kullanıcı adı veya şifre hatalı.");
        }

        scanner.close();
    }
}
