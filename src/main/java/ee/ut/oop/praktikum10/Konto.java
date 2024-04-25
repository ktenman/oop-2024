package ee.ut.oop.praktikum10;

public class Konto {
	private String omanikuNimi;
	private double rahaSumma;
	
	public Konto(String omanikuNimi, double rahaSumma) {
		setOmanikuNimi(omanikuNimi);
		setRahaSumma(rahaSumma);
	}
	
	public void setOmanikuNimi(String omanikuNimi) {
		this.omanikuNimi = omanikuNimi;
	}
	
	public void setRahaSumma(double rahaSumma) {
		if (rahaSumma < 0) {
			throw new NegatiivneSummaErind(rahaSumma);
		}
		this.rahaSumma = rahaSumma;
	}
	
	public void osta(double maksumus) {
		if (maksumus < 0) {
			throw new NegatiivneSummaErind(maksumus);
		}
		if (rahaSumma < maksumus) {
			throw new RahaEiJätkuErind();
		}
		rahaSumma = rahaSumma - maksumus;
	}
	
	public void paneJuurde(double summa) {
		setRahaSumma(rahaSumma + summa);
	}
	
	@Override
	public String toString() {
		return "Konto{" +
				"omanikuNimi='" + omanikuNimi + '\'' +
				", rahaSumma=" + rahaSumma +
				'}';
	}
}
