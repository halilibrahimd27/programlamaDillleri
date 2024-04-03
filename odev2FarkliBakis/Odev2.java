package odev2FarkliBakis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Odev2 {

    public static void main(String[] args) {
    	
    	Fonksiyonlar test = new Fonksiyonlar(7);
    	
        Scanner sc = new Scanner(System.in);
        System.out.print("Dosya adını girin: ");
        String dosyaAdi = sc.nextLine();

        Fonksiyonlar tst = null;

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            int satirSayisi = 0;
            while (br.readLine() != null) {
                satirSayisi++;
            }
            tst = new Fonksiyonlar(satirSayisi);

            br.close();
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            System.exit(1);
        }

        try (BufferedReader bre = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            int index = 0;
            while ((satir = bre.readLine()) != null) {
                int deger = Integer.parseInt(satir.trim());
                tst.ekle(index, deger, index);
                index++;
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Normal index sıralaması:");
        tst.yazdir();

        tst.veriyeGoreSirala();

        System.out.println("\nVerilere göre sıralı indexler:");
        tst.yazdir();

        sc.close();
    }
}
