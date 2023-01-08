//Akylai Bolotbekova NO:20010011520
package FinalOdevi;

import java.util.List;

public class Kursiyer {
	private int kursiyerId;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
	public List<Kurs> alinanKurslar;
	
	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas, List<Kurs> alinanKurslar) {
		super();
		this.kursiyerId = kursiyerId;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}

	public int getKursiyerId() {
		return kursiyerId;
	}

	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}

	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}

	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}

	public int getKursiyerYas() {
		return kursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}
	

}
