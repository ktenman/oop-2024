package ee.ut.oop.praktikum10.ex3;

public class Fraas {
	private String fraas;
	
	public Fraas(String fraas) throws PalindroomiErind {
		this.fraas = fraas;
		if (onPalindroom(fraas)) {
			throw new PalindroomiErind("Fraas on palindroom");
		}
	}
	
	private boolean onPalindroom(String fraas) {
		if (fraas == null) {
			System.out.println("Fraas ei saa olla `null`");
		}
		if ("".equals(fraas)) {
			System.out.println("Fraas ei saa olla tühjus");
		}
		String pööratud = new StringBuilder(fraas).reverse().toString();
		return fraas.equalsIgnoreCase(pööratud);
	}
	
	@Override
	public String toString() {
		return fraas;
	}
}
