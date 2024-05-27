package odev3;

public class IkiliArama {

    static class AramaAdim {
        int altSinir;
        int ustSinir;
        
        AramaAdim(int altSinir, int ustSinir) {
            this.altSinir = altSinir;
            this.ustSinir = ustSinir;
        }
    }

    public static int ikiliArama(int[] dizi, int hedef) {
        AramaAdim[] aramaStack = new AramaAdim[dizi.length];
        int stackIndeks = -1; 

        int adimSayisi = 0; 
        int altSinir, ustSinir, orta;
        aramaStack[++stackIndeks] = new AramaAdim(0, dizi.length - 1);
        adimSayisi++;
        System.out.println("Adım " + adimSayisi + ": Başlangıç: altSinir=0, ustSinir=" + (dizi.length - 1));

        while (stackIndeks >= 0) {
            AramaAdim adim = aramaStack[stackIndeks--];
            altSinir = adim.altSinir;
            ustSinir = adim.ustSinir;

            if (altSinir > ustSinir) {
                continue;
            }

            orta = (altSinir + ustSinir) / 2;
            adimSayisi++;
            System.out.println("Adım " + adimSayisi + ": Alt sınır=" + altSinir + ", Üst sınır=" + ustSinir + ", Orta=" + orta);

            if (dizi[orta] == hedef) {
                System.out.println("Adım " + adimSayisi + ": Hedef eleman " + hedef + " dizide indeksi: " + orta);
                return orta;
            } else if (dizi[orta] < hedef) {
                aramaStack[++stackIndeks] = new AramaAdim(orta + 1, ustSinir);
                System.out.println("Adım " + adimSayisi + ": Sağ yarıya geçildi.");
            } else {
                aramaStack[++stackIndeks] = new AramaAdim(altSinir, orta - 1);
                System.out.println("Adım " + adimSayisi + ": Sol yarıya geçildi.");
            }
        }

        System.out.println("Adım " + adimSayisi + ": Hedef eleman dizide bulunamadı.");
        return -1;
    }

    public static void main(String[] args) {
        int[] dizi = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int hedef = 13;

        int sonuc = ikiliArama(dizi, hedef);
    }
}
