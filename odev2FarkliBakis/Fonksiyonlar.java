package odev2FarkliBakis;

public class Fonksiyonlar {

	public int[] deger;
	public int[] adres;
	public int boyut;

    public Fonksiyonlar(int boyut) {
        this.boyut = boyut;
        this.deger = new int[boyut];
        this.adres = new int[boyut];
    }

    public void ekle(int index, int deger, int adres) {
        this.deger[index] = deger;
        this.adres[index] = adres;
    }

    public void veriyeGoreSirala() {
        int[] siraliIndex = new int[boyut];
        for (int i = 0; i < boyut; i++) {
        	siraliIndex[i] = i;
        }

        for (int i = 0; i < boyut - 1; i++) {
            for (int j = i + 1; j < boyut; j++) {
                if (this.deger[siraliIndex[i]] > this.deger[siraliIndex[j]]) {
                    int gecici = siraliIndex[i];
                    siraliIndex[i] = siraliIndex[j];
                    siraliIndex[j] = gecici;
                }
            }
        }

        int[] yeniAdres = new int[boyut];
        for (int i = 0; i < boyut; i++) {
        	yeniAdres[siraliIndex[i]] = i;
        }

        this.adres = yeniAdres;
    }

    public void yazdir() {
        for (int i = 0; i < boyut; i++) {
            System.out.println(deger[i] + " " + adres[i]);
        }
    }
}
