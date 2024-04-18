package ee.ut.oop.praktikum9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Kodeeringud {
	public static void main(String[] args) {
		System.out.println("Vaikekodeering: " + Charset.defaultCharset());
		
		String failiNimi = "tekst.txt";
		String tekst = "Andje käsi väsis ära, võtje käsi ei väsi kunagi";
		
		try (BufferedWriter kirjutaja = new BufferedWriter(new FileWriter(failiNimi,
				StandardCharsets.UTF_8))) {
			kirjutaja.write(tekst);
		} catch (Exception e) {
			System.out.println("Teksti kirjutamine ebaõnnestus");
			e.printStackTrace();
		}
		
		try (BufferedReader lugeja = new BufferedReader(new FileReader(failiNimi, StandardCharsets.UTF_8))) {
			String rida = lugeja.readLine();
			System.out.println("Tekst: " + rida);
		} catch (Exception e) {
			System.out.println("Teksti lugemine ebaõnnestus");
			e.printStackTrace();
		}
		
	}
	
}
