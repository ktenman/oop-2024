package ee.ut.oop.praktikum5;

import java.util.ArrayList;
import java.util.List;

public class Külastaja {
	private List<String> külastuseKirjeldused = new ArrayList<>();
	
	public Külastaja() {
		this.külastuseKirjeldused.addAll(List.of(
				"Lõbustuspark asub Tartus",
				"Lõbustuspark on avatud iga päev"
		));
	}
	
	public void lisaKirjeldus(String sõne) {
		külastuseKirjeldused.add(sõne);
	}
	
	public List<String> kõikKirjeldused() {
		return külastuseKirjeldused;
	}
}
