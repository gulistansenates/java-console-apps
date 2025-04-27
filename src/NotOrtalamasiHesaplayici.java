import java.util.Scanner;

public class NotOrtalamasiHesaplayici {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan ders sayısını alıyoruz
        System.out.print("Kaç dersin notunu gireceksiniz? ");
        int dersSayisi = scanner.nextInt();

        // Ders isimlerini ve notlarını saklamak için diziler oluşturuyoruz
        String[] dersler = new String[dersSayisi];
        double[] notlar = new double[dersSayisi];

        // Ders isimlerini ve notlarını kullanıcıdan alıyoruz
        for (int i = 0; i < dersSayisi; i++) {
            System.out.print("Dersin adı: ");
            dersler[i] = scanner.next();

            // Kullanıcıdan geçerli bir not alana kadar döngü devam eder
            while (true) {
                System.out.print(dersler[i] + " dersinin notunu girin: ");
                if (scanner.hasNextDouble()) {
                    notlar[i] = scanner.nextDouble();
                    break;  // Geçerli bir not alındığında döngüden çık
                } else {
                    System.out.println("Geçersiz bir not girdiniz. Lütfen bir sayı girin.");
                    scanner.next();  // Geçersiz girişten sonra, Scanner'ı temizleriz
                }
            }
        }

        // Not ortalamasını hesaplıyoruz
        double toplamNot = 0;
        for (int i = 0; i < dersSayisi; i++) {
            toplamNot += notlar[i];
        }
        double ortalama = toplamNot / dersSayisi;

        // Harf notunu hesaplıyoruz
        String harfNotu = "";
        if (ortalama >= 90) {
            harfNotu = "AA";
        } else if (ortalama >= 85) {
            harfNotu = "BA";
        } else if (ortalama >= 80) {
            harfNotu = "BB";
        } else if (ortalama >= 75) {
            harfNotu = "CB";
        } else if (ortalama >= 70) {
            harfNotu = "CC";
        } else if (ortalama >= 65) {
            harfNotu = "DC";
        } else if (ortalama >= 60) {
            harfNotu = "DD";
        } else if (ortalama >= 50) {
            harfNotu = "FD";
        } else {
            harfNotu = "FF";
        }

        // Sonuçları ekrana yazdırıyoruz
        System.out.println("\nNot Ortalaması: " + ortalama);
        System.out.println("Harf Notu: " + harfNotu);
    }
}
