package ee.ut.oop.praktikum9;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VooSulgemine {
	public static void main(String[] args) {
		String failiNimi = args[0];
		List<InputStream> vood = new ArrayList<>();
		
		try {
			FileInputStream sisendVoog = new FileInputStream(failiNimi);
			vood.add(sisendVoog);
			sisendVoog.close();
		} catch (Exception e) {
			System.out.println("Faili lugemine ebaõnnestus");
			e.printStackTrace();
		}
		
		System.out.println("Avatud failide arv: " + vood.size());
	}
}
