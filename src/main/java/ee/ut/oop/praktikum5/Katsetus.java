package ee.ut.oop.praktikum5;

public class Katsetus {
	public static void main(String[] args) {
		Vaateratas vaateratas = new Vaateratas();
		Lasketiir lasketiir = new Lasketiir();
		LõbustusPark lõbustusPark = new LõbustusPark(vaateratas, lasketiir, lasketiir);
		Külastaja külastaja = new Külastaja();
		lõbustusPark.alustaSeiklust(külastaja);
	}
}
