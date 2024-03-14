package ee.ut.oop.praktikum5;

public class Katsetus {
	public static void main(String[] args) {
		Vaateratas vaateratas = new Vaateratas();
		Lasketiir lasketiir = new Lasketiir();
		VanuseKontrollija vanuseKontrollija = new VanuseKontrollija(12, lasketiir);
		LõbustusPark lõbustusPark = new LõbustusPark(vaateratas, lasketiir, vanuseKontrollija);
		Külastaja külastaja = new Külastaja(11);
		lõbustusPark.alustaSeiklust(külastaja);
		
		külastaja = new Külastaja(13);
		
		lõbustusPark.alustaSeiklust(külastaja);
	}
}
