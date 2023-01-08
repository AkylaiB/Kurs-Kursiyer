//Akylai Bolotbekova NO:20010011520
package FinalOdevi;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AnaSayfa {
	public static ArrayList<Kursiyer> kursiyerler = new ArrayList<Kursiyer>();
	public static ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
	
	
	public static void kEkle() {
		Scanner scan = new Scanner(System.in);
		int ctrl=0, id;
		String ad;
		System.out.println("Yeni kursun ID:");
		id=scan.nextInt();
		for(Kurs k:kurslar)
		{
			if(k.getKursId()==id)
			{
				System.out.println("Bu ID'de baska kayit vardir!");
				ctrl=1;
				break;
			}
		}
		if(ctrl!=1) {
			System.out.println("Yeni kursun adi:");
			ad=scan.next();
			kurslar.add(new Kurs(id,ad));
			System.out.println("Yeni kurs basariyla eklendi!");}
	}
	
	public static void kListele()
	{
		System.out.println("\nKurs Id   Kurs Adi");
		System.out.println("-------   --------");
		for(Kurs k:kurslar)
			System.out.println(" "+k.getKursId()+"     "+k.getKursAd());
		
	}
	
	public static void krEkle()
	{
		Scanner scan = new Scanner(System.in);
		int kId, Id, ctrl=0,yas;
		String kAd,adSd;
		List<Kurs> alKurslar = new ArrayList<Kurs>();
		System.out.println("Yeni kursiyerin ID:");
		Id=scan.nextInt();
		for(Kursiyer kr:kursiyerler) {
			if(kr.getKursiyerId()==Id)
			{
				System.out.println("Bu ID'de baska kayit vardir!");
				ctrl=1;
				break;
			}
		}
		if(ctrl!=1)
		{
			System.out.println("Yeni kursiyerin adi soyadi:");
			scan.nextLine();
			adSd=scan.nextLine();
			System.out.println("Yeni kursiyerin yasi:");
			yas=scan.nextInt();
			System.out.println("Kursiyerin istedigi kurs sayisi:");
		    int ks=scan.nextInt();
		    for(int i=0; i<ks; i++)
		    {
			   System.out.println(i+1+".Yeni kursun ID:");
			   kId=scan.nextInt();
			   System.out.println(i+1+".Yeni kursun adi:");
			   kAd=scan.next();
			   alKurslar.add(new Kurs(kId,kAd));
		    }
		    kursiyerler.add(new Kursiyer(Id,adSd,yas,alKurslar));
		    System.out.println("Yeni kursiyer basariyla eklendi!");
		}
	}
	
	public static void ara(String adSd)
	{ 
		int ctrl=0;
		for(Kursiyer krs:kursiyerler)
		{
			if(krs.getKursiyerAdSoyad().equals(adSd))
			{
				ctrl=1;
				System.out.println("ID:"+krs.getKursiyerId()+" Ad Soyad:"+krs.getKursiyerAdSoyad()+" Yas:"+krs.getKursiyerYas());
				for(Kurs ks: krs.alinanKurslar)
					System.out.println("    "+ks.getKursId()+"-"+ks.getKursAd());
			}
				
		}
		if(ctrl==0)
			System.out.println("Maalesef kayit bulunamadi...");
	}
	
	
	public static void sil(int id)
	{
		int ctrl=0;
		
		for(Kursiyer krs:kursiyerler)
		{
			if(krs.getKursiyerId()==id)
			{
				ctrl=1;
				kursiyerler.remove(krs);
				System.out.println("Kayit basariyla silindi.");
				break;
			}	
		}
		if(ctrl==0)
			System.out.println("Maalesef kayit bulunamadi...");
	}
	
	
	public static void krListele()
	{

		System.out.println("\nTum Kursiyerler");
		System.out.println("-----------------");
		for(Kursiyer kr:kursiyerler) {
			System.out.println(kr.getKursiyerId()+" "+kr.getKursiyerAdSoyad()+" "+kr.getKursiyerYas());}
	}
	
	
	public static void krAListele()
	{
		System.out.println("\nTum Kursiyerler ve Aldiklari Kurslar:");
		System.out.println("-------------------------------------");
		for(Kursiyer kr:kursiyerler) {
			System.out.println(kr.getKursiyerId()+" "+kr.getKursiyerAdSoyad()+" "+kr.getKursiyerYas());
			for(Kurs kk:kr.alinanKurslar)
				System.out.println("    "+kk.getKursId()+" "+kk.getKursAd());}
	}
	
	
	public static void tutarHesapla(int id) 
	{
		int kSayisi=0, ctrl=0;
		double tutar;
		for(Kursiyer kr: kursiyerler)
		{
			if(kr.getKursiyerId()==id)
			{
				ctrl=1;
				kSayisi=kr.alinanKurslar.size();
				//her bir kurs 100TL
			    System.out.println(kr.getKursiyerAdSoyad()+":");
			    if(kSayisi>3)  
			    {
				   System.out.println("3.kanpanya: her bir kurs %10 indirimli.");
				   tutar=kSayisi*(100-100*0.1);
			    }
			    else if(kSayisi==3)  
			    {
				    System.out.println("2.kanpanya: ucuncu kurs %25 indirimli.");
				    tutar=2*100+(100-100*0.25);
			    }
			    else if(kSayisi==2) 
			    {
				    System.out.println("1.kanpanya: ikinci kurs %15 indirimli.");
				    tutar=100+(100-100*0.15);
			    }
			    else 
			    {
				    System.out.println("Tek kurs alanlar icin kampanya bulunmamaktadir.");
				    tutar=100;
			    }
			    System.out.println("Aylik toplam ucret = "+tutar+" TL");
				break;
			}
		}
		if(ctrl==0)
			System.out.println("Maalesef kayit bulunamadi...");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int kId, KId, krId = 0, yas = 0, k_ctrl=0;
		String adSoyad = null, KAd, kAd;
		ArrayList<Kurs> alKurslar = new ArrayList<Kurs>();
		String line;
		String dline[] = new String[50];
		try {
			File file1 = new File("kursiyer.txt");
			if(!file1.exists())
				file1.createNewFile();
			FileReader Fr = new FileReader(file1);
			BufferedReader Br = new BufferedReader(Fr);
				while((line = Br.readLine())!=null)
				{
					if(line.startsWith("*"))
					{
						if(k_ctrl==1) {
							kursiyerler.add(new Kursiyer(krId,adSoyad,yas,alKurslar));
							k_ctrl=0;
							alKurslar = new ArrayList<Kurs>();
							}
						
						line = line.replace("*", "");
						dline = line.split("-");
						krId = Integer.parseInt(dline[0]);
						adSoyad = dline[1];
						yas = Integer.parseInt(dline[2]);
					}
					else 
					{
						k_ctrl=1;
						line = line.replace("%", "");
						dline = line.split("-");
						kId = Integer.parseInt(dline[0]);
						kAd = dline[1];
						alKurslar.add(new Kurs(kId,kAd));
					}
				}
				kursiyerler.add(new Kursiyer(krId,adSoyad,yas,alKurslar));
			
			File file2 = new File("kurs.txt");
			if(!file2.exists())
				file2.createNewFile();
			FileReader fr = new FileReader(file2);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
				dline = line.split("-");
				KId = Integer.parseInt(dline[0]);
				KAd = dline[1];
				kurslar.add(new Kurs(KId,KAd));
			}
			
			fr.close();
			br.close();
			Fr.close();
			Br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		int ctrl=1, secim;
		while(ctrl==1)
		{
			System.out.print("\n------MENU------\n");
			System.out.print("1-Kurs Ekle\n2-Kurs Listele\n3-Kursiyer Ekle\n4-Kursiyer Ara\n5-Kursiyer Sil\n6-Kursiyerleri listele\n7-Kursiyerleri Ayrintili Listele\n8-Kursiyerin Odeyecegi Tutari Hesapla\n9-Cikis");
			System.out.print("\nIslem seciniz:");
			secim=scan.nextInt();
			switch(secim) {
			case 1:
				
				kEkle();
				break;
			case 2:
				kListele();
				break;
			case 3:
				krEkle();
				break;
			case 4:
				System.out.print("Aranan kursiyerin adi soyadi:");
				scan.nextLine();
				adSoyad=scan.nextLine();
				ara(adSoyad);
				break;
			case 5:
				System.out.println("Silinecek kursiyerin ID:");
				krId=scan.nextInt();
				sil(krId);
				krListele();
				break;
			case 6:
				krListele();
				break;
			case 7:
				krAListele();
				break;
			case 8:
				System.out.println("Tutari hesaplanacak kursiyerin ID:");
				krId=scan.nextInt();
				tutarHesapla(krId);
				break;
			case 9:
				ctrl=0;
				try 
				{
					PrintStream writer = new PrintStream(new File("kursiyer.txt"));
					for(Kursiyer kr: kursiyerler)
					{
						writer.println("*"+kr.getKursiyerId()+"-"+kr.getKursiyerAdSoyad()+"-"+kr.getKursiyerYas());
						for(Kurs kks:kr.alinanKurslar)
						{
							writer.println("%"+kks.getKursId()+"-"+kks.getKursAd());
						}
					}
					PrintStream writer2 = new PrintStream(new File("kurs.txt"));
					for(Kurs ks: kurslar)
					{
						writer2.println(ks.getKursId()+"-"+ks.getKursAd());
					}
				}catch(IOException e) {
					System.out.println("Bir hata olustu!");
				}
				break;
			default:
				System.out.println("Yanlis secim yapildi!");
			}
		}
	}

}
