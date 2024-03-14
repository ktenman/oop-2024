package ee.ut.oop.praktikum5;

public class LõbustusPark {
	private Vaateratas lõbustus;
	
	public LõbustusPark(Vaateratas vaateratas) {
		this.lõbustus = vaateratas;
	}
	
	public void alustaSeiklust(Külastaja külastaja) {
		System.out.println("alustan seiklust");
		lõbustus.lõbusta(külastaja);
		
		külastaja.kõikKirjeldused().forEach(System.out::println);
		
		for (String kirjeldus : külastaja.kõikKirjeldused()) {
			System.out.println(kirjeldus);
		}
	}
}
