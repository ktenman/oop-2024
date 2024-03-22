package ee.ut.oop.praktikum6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Peaklass {
	
	public static void main(String[] args) throws Exception {
		List<Teos> teosed = loeTeosed("teosed.txt");
		
		Collections.sort(teosed);
		ViiviseHoiataja viiviseHoiataja = new ViiviseHoiataja(0.2);
		SuurimaViiviseLeidja suurimaViiviseLeidja = new SuurimaViiviseLeidja();
		
		for (Teos teos : teosed) {
			teos.arvutaViivis(viiviseHoiataja);
			teos.arvutaViivis(suurimaViiviseLeidja);
		}
		
		System.out.println("Hoiatavad laenutajad: " + viiviseHoiataja.getHoiatavadLaenutajad());
		suurimaViiviseLeidja.saadaHoiatus();
	}
	
	public static List<Teos> loeTeosed(String failiNimi) throws IOException {
		List<Teos> teosed = new ArrayList<>();
		String tekst = Files.readString(Paths.get(failiNimi), StandardCharsets.UTF_8).replace("\r", "");
		String[] read = tekst.split("\n");
		for (String rida : read) {
			String[] osad = rida.split("; ");
			if (rida.contains("/")) {
				teosed.add(new Ajakiri(osad[0], osad[1], osad[2], Integer.parseInt(osad[3])));
			} else {
				teosed.add(new Raamat(osad[0], osad[1], osad[2], Integer.parseInt(osad[3])));
			}
		}
		return teosed;
	}
	
}
