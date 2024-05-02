package ee.ut.oop.praktikum11;

import java.time.LocalDateTime;

public class VäliseMonitorigaArvuti extends Arvuti {
	public VäliseMonitorigaArvuti(String tootja, boolean kiirtöö, LocalDateTime registreemiseAeg) {
		super(tootja, kiirtöö, registreemiseAeg);
	}
	
	@Override
	public double arvutaArveSumma(double baasHind) {
		return super.arvutaArveSumma(baasHind) + 1;
	}
	
	// Ordi;kiirtöö;monitoriga@2024-04-12T10:12:45
	@Override
	public String toString() {
		return getTootja() + ';' + tööTüüp() + ";monitoriga@" + getRegistreemiseAeg();
	}
}
