package ee.ut.oop.praktikum10;

public class RahaEiJätkuErind extends RuntimeException {
	public RahaEiJätkuErind(String message) {
		super(message);
	}
	
	public RahaEiJätkuErind() {
		super("Liiga vähe raha kontol");
	}
}
