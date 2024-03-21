package ee.ut.oop.praktikum6;

import java.util.ArrayList;
import java.util.List;

public class ViiviseHoiataja implements Kontrollija {
	
	private final double lubatudViivis;
	private final List<String> hoiatavadLaenutajad = new ArrayList<>();
	
	public ViiviseHoiataja(double lubatudViivis) {
		this.lubatudViivis = lubatudViivis;
	}
	
	@Override
	public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viivis) {
		if (viivis > lubatudViivis && !hoiatavadLaenutajad.contains(laenutajaNimi)) {
			hoiatavadLaenutajad.add(laenutajaNimi);
		}
	}
	
	public List<String> getHoiatavadLaenutajad() {
		return hoiatavadLaenutajad;
	}
}
