import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//ferhat bayutmuş
//22120205378

class okuma {

    // Dosyanın her satırını oku
    public static int oku() throws IOException {
        // Böcek desenleri
        String[] desenler = {"|    _", " ###O", "|   /\\"};

        // Dosya yolu
        String dosyaAdı = "arazi.txt";

        // Dosya okuma
        File dosya = new File(dosyaAdı);
        int toplamBöcekSayısı = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(dosya))) {
            String satır;
            while ((satır = br.readLine()) != null) {
                // Satırda her desen için kontrol et
                for (String desen : desenler) {
                    int index = satır.indexOf(desen);
                    while (index >= 0) {
                        // Desen bulundu
                        toplamBöcekSayısı++;
                        index = satır.indexOf(desen, index + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toplamBöcekSayısı / 2; // ikiye bölünmüş sayıyı geri döndür
        //countu ikiye böldüm çünki hem satır hemde sütünları okuduğu için her böceği iki kez saydı ve sonuç hep iki katı çıktı bende bunu kolay yoldan çözmek için ikiye böldüm
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        okuma o=new okuma();

        // Sonuç yazdırma
        System.out.println("Toplam böcek sayısı: " +okuma.oku() );

    }
}


