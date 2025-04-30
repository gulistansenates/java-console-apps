import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(" Sayı Tahmin Oyununa Hoş Geldiniz!");
        System.out.println("Zorluk seviyesi seçin:");
        System.out.println("1. Kolay (1-10)");
        System.out.println("2. Orta (1-100)");
        System.out.println("3. Zor (1-1000)");

        int maxSayi = 100;
        System.out.print("Seçiminiz (1-3): ");
        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                maxSayi = 10;
                break;
            case 2:
                maxSayi = 100;
                break;
            case 3:
                maxSayi = 1000;
                break;
            default:
                System.out.println("Geçersiz seçim, varsayılan olarak Orta (1-100) seçildi.");
        }
        int rastgeleSayi = random.nextInt(maxSayi) + 1;
        int tahmin;
        int tahminSayisi = 0;

        System.out.println("\n1 ile " + maxSayi + " arasında bir sayı tuttum. Tahmin etmeye çalış!");

        do {
            System.out.print("Tahmininiz: ");
            tahmin = scanner.nextInt();
            tahminSayisi++;

            if (tahmin < rastgeleSayi) {
                System.out.println("Daha büyük bir sayı girin.");
            } else if (tahmin > rastgeleSayi) {
                System.out.println("Daha küçük bir sayı girin.");
            } else {
                System.out.println("🎉 Tebrikler! " + tahminSayisi + " tahminde doğru sayıyı buldunuz.");
            }

        } while (tahmin != rastgeleSayi);

        scanner.close();
    }
}
