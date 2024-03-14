package odev1;

import java.util.Scanner;

public class GramerKontrol {
	
	private static Scanner scanner;
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);

        String[] ozneListesi = {"ben", "sen", "hasan", "nurşah", "elif", "abdulrezzak", "şehribanu", "zeynelabidin", "naki"};
        String[] nesneListesi = {"bahçe", "okul", "park", "sınıf", "yarın", "pazartesi", "salı", "çarşamba", "perşembe", "cuma", "cumartesi", "pazar", "merkez", "ev", "kitap", "defter", "güneş", "beydağı"};
        String[] yuklemListesi = {"gitmek", "gelmek", "okumak", "yazmak", "yürümek", "görmek"};
        
        System.out.println("Lütfen özne + nesne + yüklem'den oluşan bir cümle giriniz : \n");
        String cumle = scanner.nextLine().trim().toLowerCase();
        
        String[] kelimeler = cumle.split("\\s+");
        
        boolean uygunMu = false;
        
        for (int i = 0; i < ozneListesi.length; i++) {
			if (kelimeler[0].equals(ozneListesi[i])) {
				for (int j = 0; j < nesneListesi.length; j++) {
					if (kelimeler[1].equals(nesneListesi[j])) {
						for (int k = 0; k < yuklemListesi.length; k++) {
							if (kelimeler[2].equals(yuklemListesi[k])) {
								uygunMu = true;
							}
						}
					}
				}
			}
		}
        
        if (uygunMu) {
        	System.out.println("EVET");
		}else {
			System.out.println("HAYIR");
		}
	}
}