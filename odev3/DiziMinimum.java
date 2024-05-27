package odev3;

public class DiziMinimum {

    static class MinimumAdim {
        int baslangic;
        int bitis;
        
        MinimumAdim(int baslangic, int bitis) {
            this.baslangic = baslangic;
            this.bitis = bitis;
        }
    }

    public static int minimumBul(int[] dizi) {
        MinimumAdim[] minimumStack = new MinimumAdim[dizi.length]; 
        int stackIndeks = -1; 

        int adimSayisi = 0;
        minimumStack[++stackIndeks] = new MinimumAdim(0, dizi.length - 1);
        adimSayisi++;
        System.out.println("Adım " + adimSayisi + ": Başlangıç: baslangic=0, bitis=" + (dizi.length - 1));

        int baslangic, bitis, orta;
        int min = Integer.MAX_VALUE;

        while (stackIndeks >= 0) {
            MinimumAdim adim = minimumStack[stackIndeks--];
            baslangic = adim.baslangic;
            bitis = adim.bitis;

            if (baslangic == bitis) {
                min = Math.min(min, dizi[baslangic]); 
                System.out.println("Adım " + adimSayisi + ": Tek elemanlı alt dizi, minimum değer bu elemandır: " + min);
            } else {
                orta = (baslangic + bitis) / 2;
                minimumStack[++stackIndeks] = new MinimumAdim(baslangic, orta);
                minimumStack[++stackIndeks] = new MinimumAdim(orta + 1, bitis);
                System.out.println("Adım " + adimSayisi + ": Alt sıralama için: baslangic=" + baslangic + ", orta=" + orta);
                System.out.println("Adım " + adimSayisi + ": Üst sıralama için: orta=" + (orta + 1) + ", bitis=" + bitis);
            }
            adimSayisi++;
        }

        System.out.println("Adım " + adimSayisi + ": Dizinin minimum değeri: " + min);
        return min;
    }

    public static void main(String[] args) {
        int[] dizi = {9, 12, 3, 7, 25, 6, 10};

        int min = minimumBul(dizi);
    }
}
