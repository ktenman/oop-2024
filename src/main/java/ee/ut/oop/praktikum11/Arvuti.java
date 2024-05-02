package ee.ut.oop.praktikum11;

import java.time.LocalDateTime;

public class Arvuti {
	private String tootja;
	private boolean kiirtöö;
	private LocalDateTime registreemiseAeg;
	
	public Arvuti(String tootja, boolean kiirtöö, LocalDateTime registreemiseAeg) {
		this.tootja = tootja;
		this.kiirtöö = kiirtöö;
		this.registreemiseAeg = registreemiseAeg;
	}
	
	public String getTootja() {
		return tootja;
	}
	
	public boolean onKiirtöö() {
		return kiirtöö;
	}
	
	public LocalDateTime getRegistreemiseAeg() {
		return registreemiseAeg;
	}
	
	public String tööTüüp() {
		return kiirtöö ? "kiirtöö" : "tavatöö";
	}
	
	/*
	Baashind arvutatakse parandamiseks kulunud aja ning parandaja tunnitasu põhjal.
	Lõpphinna saamiseks lisatakse baashinnale fikseeritud summa töö vastuvõtmise eest
	(2€ arvuti eest ja täiendav +1€ välise monitori puhul) ning lisaks veel 10€
	 kiirtellimuse puhul.
	 */
	public double arvutaArveSumma(double baasHind) {
		double arveSumma = baasHind + 2;
		if (onKiirtöö()) {
			arveSumma += 10;
		}
		return arveSumma;
	}
	
	@Override
	public String toString() {
		return tootja + ';' + tööTüüp() + "@" + registreemiseAeg;
	}
}
