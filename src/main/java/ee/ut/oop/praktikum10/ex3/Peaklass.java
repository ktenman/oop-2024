package ee.ut.oop.praktikum10.ex3;

public class Peaklass {
	public static void main(String[] args) {
		try {
			Fraas fraas = new Fraas("Aias sadas saia");
			System.out.println(fraas);
		} catch (PalindroomiErind erind) {
			System.out.println("Viga: " + erind);
		}
		
		try {
			Fraas fraas = new Fraas("Ann");
			System.out.println(fraas);
		} catch (PalindroomiErind erind) {
			System.out.println("Viga: " + erind);
		}
	}
}
