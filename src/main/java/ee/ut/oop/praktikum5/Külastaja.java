package ee.ut.oop.praktikum5;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
	private List<String> külastuseKirjeldused = new ArrayList<>();
	private int vanus;
	
	public int getVanus() {
		return vanus;
	}
	
	public Külastaja(int vanus) {
		this.vanus = vanus;
		lisaKirjeldused();
	}
	
	private void lisaKirjeldused() {
		this.külastuseKirjeldused.addAll(List.of(
				"Lõbustuspark asub Tartus",
				"Lõbustuspark on avatud iga päev"
		));
	}
	
	public Külastaja() {
		lisaKirjeldused();
	}
	
	public void lisaKirjeldus(String sõne) {
		külastuseKirjeldused.add(sõne);
	}
	
	public List<String> kõikKirjeldused() {
		return külastuseKirjeldused;
	}
}
