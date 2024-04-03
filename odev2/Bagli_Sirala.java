package odev2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner; 

public class Bagli_Sirala {
	
	public static void main(String[] args) {
		
		Fonksiyonlar fonksiyonlar = new Fonksiyonlar();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Dosyanızın adını giriniz: ");
		String dosyaAdi = sc.nextLine();
		
		System.out.println("\nDosyanızın ilk hali: ");
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(dosyaAdi));
			String satir;
			
			while ((satir = br.readLine()) != null) {
				System.out.println(satir);
				String[] bolumler = satir.trim().split("\\s+");
				int deger = Integer.parseInt(bolumler[0]);
				int adres = Integer.parseInt(bolumler[1]);
				fonksiyonlar.ekle(deger, adres);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Dosyanız okunamadı." + e.getMessage());
		}
		
		fonksiyonlar.sirala();
		
		System.out.println("\nDosyanızın düzenlenmiş hali: ");
		
		fonksiyonlar.listeyiYaz();
		
		sc.close();
	}
}
