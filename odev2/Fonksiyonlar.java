package odev2;

public class Fonksiyonlar {
	
	private Node head;
	
	public Fonksiyonlar() {
		this.head = null;
	}
	
	
	public void ekle(int deger, int adres) {
		Node yeniDugum = new Node(deger, adres);
		if(head == null) {
			head = yeniDugum;
		}else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = yeniDugum;
		}
	}
	
	public void sirala() {
		Node current = head;
		Node index = null;
		int geciciDeger, geciciAdres;
		
		if(head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;
				
				while (index != null) {
					if(current.adres > index.adres) {

						geciciDeger = current.deger;
						current.deger = index.deger;
						index.deger = geciciDeger;
						
						geciciAdres = current.adres;
						current.adres = index.adres;
						index.adres = geciciAdres;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}
	
	public void listeyiYaz() {
		Node current = head;
		while (current != null) {
			System.out.println(current.deger + "  " + current.adres);
			current = current.next;
		}
	}
}
