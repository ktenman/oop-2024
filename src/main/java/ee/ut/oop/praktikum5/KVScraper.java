package ee.ut.oop.praktikum5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Scanner;

public class KVScraper {
	
	private final String linn;
	
	public KVScraper(String linn) {
		if (linn == null || linn.isEmpty()) {
			throw new IllegalArgumentException("Linn ei tohi olla tühi");
		}
		this.linn = linn;
	}
	
	public double hind(String text) {
		try {
			return Double.parseDouble(text.split(" €")[0].replace(" ", ""));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		Configuration.headless = true;
		Configuration.browser = "firefox";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Sisesta linn või 'exit' lõpetamiseks");
			String sisend = scanner.nextLine();
			if (sisend.equals("exit")) {
				Selenide.closeWebDriver();
				break;
			}
			KVScraper KVScraper = new KVScraper(sisend);
			System.out.println(KVScraper.arvutaKeskmineHind());
		}
	}
	
	public double arvutaKeskmineHind() {
		Selenide.open("https://kv.ee");
		Selenide.sleep(2000);
		SelenideElement terms = Selenide.$(By.id("onetrust-accept-btn-handler"));
		if (terms.exists()) {
			terms.click();
		}
		Selenide.$(By.id("keyword")).setValue(this.linn);
		Selenide.$$(By.tagName("span")).find(Condition.text("Otsi")).click();
		Selenide.$(By.className("fa-list")).click();
		Selenide.sleep(2000);
		
		ElementsCollection elements = Selenide.$(By.className("results")).findAll(By.className("price"));
		double summa = 0;
		for (SelenideElement element : elements) {
			summa += hind(element.getText());
		}
		
		return summa / elements.size();
	}
}
