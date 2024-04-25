package ee.ut.oop.praktikum10;

public class NegatiivneSummaErind extends RuntimeException {
	public NegatiivneSummaErind(double summa) {
		super("Antud summa on negatiivne: " + summa);
	}
}
