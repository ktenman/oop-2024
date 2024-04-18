package ee.ut.oop.praktikum9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InimineTest {
	public static void main(String[] args) {
		String failiNimi = "inimene.dat";
		
		List<String> lapsed = new ArrayList<>();
		lapsed.add("Mari");
		lapsed.add("Kati");
		
		Inimene inimene = new Inimene("Mati", "Maasikas", lapsed);
		
		System.out.println("Enne faili kirjutamist: " + inimene);
		
		try (DataOutputStream väljundVoog = new DataOutputStream(new FileOutputStream(failiNimi))) {
			väljundVoog.writeUTF(inimene.getEesnimi());
			väljundVoog.writeUTF(inimene.getPerenimi());
			väljundVoog.writeInt(inimene.getLapsed().size());
			for (String laps : inimene.getLapsed()) {
				väljundVoog.writeUTF(laps);
			}
		} catch (IOException e) {
			System.out.println("Faili kirjutamine ebaõnnestus");
			e.printStackTrace();
		}
		
		try (DataInputStream sisendVoog = new DataInputStream(new FileInputStream(failiNimi))) {
			String eesnimi = sisendVoog.readUTF();
			System.out.println("Eesnimi: " + eesnimi);
			String perenimi = sisendVoog.readUTF();
			int lasteArv = sisendVoog.readInt();
			System.out.println("Perenimi: " + perenimi);
			System.out.println("Lastearv: " + lasteArv);
			for (int i = 0; i < lasteArv; i++) {
				String laps = sisendVoog.readUTF();
				lapsed.add(laps);
			}
			Inimene loetudInimene = new Inimene(eesnimi, perenimi, lapsed);
			System.out.println("Pärast failist lugemist: " + loetudInimene);
		} catch (IOException e) {
			System.out.println("Failist lugemine ebaõnnestus");
			e.printStackTrace();
		}
		
		
	}
}
