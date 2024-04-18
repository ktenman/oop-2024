package ee.ut.oop.praktikum9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Paroolid {
	public static void main(String[] args) {
		String sisendFail = "peidetud.txt";
		String väljundFail = "paroolid.txt";
		
		otsiParoolid(sisendFail, väljundFail);
		kuvaSalvestatudParoolid(väljundFail);
	}
	
	private static void kuvaSalvestatudParoolid(String väljundFail) {
		System.out.println("Salvestatud paroolid:");
		try (BufferedReader lugeja = new BufferedReader(new FileReader(väljundFail, UTF_8))) {
			String rida;
			while ((rida = lugeja.readLine()) != null) {
				System.out.println(rida);
			}
		} catch (Exception e) {
			System.out.println("Teksti lugemine ebaõnnestus");
			e.printStackTrace();
		}
	}
	
	private static void otsiParoolid(String sisendFail, String väljundFail) {
		try (BufferedReader lugeja = new BufferedReader(new FileReader(sisendFail, UTF_8));
		     BufferedWriter kirjutaja = new BufferedWriter(new FileWriter(väljundFail, UTF_8))) {
			
			String rida;
			while ((rida = lugeja.readLine()) != null) {
				if (rida.contains(" parool: ")) {
					String parool = rida.split(" parool: ")[1].split(" ")[0];
					kirjutaja.write(parool);
					kirjutaja.newLine();
				}
			}
			
			System.out.println("Paroolid on salvestatud faili " + väljundFail);
		} catch (Exception e) {
			System.out.println("Teksti lugemine ebaõnnestus");
			e.printStackTrace();
			
		}
	}
}
