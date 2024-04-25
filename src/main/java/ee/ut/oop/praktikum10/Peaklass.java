package ee.ut.oop.praktikum10;

public class Peaklass {
	public static void main(String[] args) {
		try {
			Konto konto = new Konto("Mati", 100);
			System.out.println(konto);
			konto.paneJuurde(-11);
			System.out.println(konto);
			konto.osta(50);
			System.out.println(konto);
			konto.osta(99999);
			
			System.out.println(konto);
			System.out.println("Kahjuks siia programm ei jõua");
		} catch (RahaEiJätkuErind e) {
			System.out.println("Raha ei jätkunud: " + e.getMessage());
		} catch (NegatiivneSummaErind e) {
			System.out.println("Negatiivne summa erind: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Viga: " + e.getMessage());
		} finally {
			System.out.println("Programm lõpetas oma töö");
		}
	}
}
