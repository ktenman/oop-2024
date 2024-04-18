package ee.ut.oop.praktikum9;

import java.util.List;

public class Inimene {
	private String eesnimi;
	private String perenimi;
	private List<String> lapsed;
	
	public Inimene(String eesnimi, String perenimi, List<String> lapsed) {
		this.eesnimi = eesnimi;
		this.perenimi = perenimi;
		this.lapsed = lapsed;
	}
	
	public String getEesnimi() {
		return eesnimi;
	}
	
	public String getPerenimi() {
		return perenimi;
	}
	
	public List<String> getLapsed() {
		return lapsed;
	}
	
	@Override
	public String toString() {
		return "Inimene{" +
				"eesnimi='" + eesnimi + '\'' +
				", perenimi='" + perenimi + '\'' +
				", lapsed=" + lapsed +
				'}';
	}
}
