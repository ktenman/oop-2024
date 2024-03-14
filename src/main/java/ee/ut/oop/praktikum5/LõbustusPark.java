package ee.ut.oop.praktikum5;

import java.util.ArrayList;
import java.util.List;

public class LõbustusPark {
	private List<Lõbustus> lõbustused = new ArrayList<>();
	
	public LõbustusPark(Lõbustus... lõbustused) {
		this.lõbustused.addAll(List.of(lõbustused));
	}
	
	public void alustaSeiklust(Külastaja külastaja) {
		for (Lõbustus lõbustus : lõbustused) {
			lõbustus.lõbusta(külastaja);
		}
		külastaja.kõikKirjeldused().forEach(System.out::println);
	}
}
