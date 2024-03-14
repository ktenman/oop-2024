package ee.ut.oop.praktikum5;

import java.util.Random;

public class Lasketiir implements Lõbustus {
	
	private Random random = new Random();
	
	public void lõbusta(Külastaja külastaja) {
		int sihtmärkideArv = random.nextInt(21);
		String kirjeldus = String.format("tabasin lasketiirus %s sihtmärki", sihtmärkideArv);
		külastaja.lisaKirjeldus(kirjeldus);
	}
}
