package ee.ut.oop.praktikum9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PuhverdatudVood {
	public static void main(String[] args) {
		String failiNimi = "puhverdatud.txt";
		
		Scanner skanner = new Scanner(System.in);
		
		System.out.println("Sisesta sõne: ");
		String sisend = skanner.nextLine();
		
		System.out.println("Sisestatud sõne: " + sisend);
		
		try (BufferedWriter kirjutaja = new BufferedWriter(new FileWriter(failiNimi, UTF_8))) {
			kirjutaja.write(sisend);
		} catch (Exception e) {
			System.out.println("Teksti kirjutamine ebaõnnestus");
			e.printStackTrace();
		}
		
		try (BufferedReader lugeja = new BufferedReader(new FileReader(failiNimi, UTF_8))) {
			String rida = lugeja.readLine();
			System.out.println("Tekst: " + rida);
		} catch (Exception e) {
			System.out.println("Teksti lugemine ebaõnnestus");
			e.printStackTrace();
		}
	}
}
