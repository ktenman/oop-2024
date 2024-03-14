package ee.ut.oop.praktikum5;

public class Katsetus {
	public static void main(String[] args) {
		Vaateratas vaateratas = new Vaateratas();
		LõbustusPark lõbustusPark = new LõbustusPark(vaateratas);
		Külastaja külastaja = new Külastaja();
		lõbustusPark.alustaSeiklust(külastaja);
	}
}
