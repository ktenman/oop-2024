package ee.ut.oop.praktikum5;

public class Vaateratas implements Lõbustus {
	
	@Override
	public void lõbusta(Külastaja külastaja) {
		külastaja.lisaKirjeldus("külastasin vaateratast");
	}
	
}
