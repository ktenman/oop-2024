package ee.ut.oop.praktikum5;

import com.codeborne.selenide.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KVScraperTest {
	
	KVScraper kvScraper = new KVScraper("Tallinn");
	
	@Test
	void arvutaKeskmineHind() {
		Configuration.headless = true;
		Configuration.browser = "firefox";
		
		Assertions.assertThat(kvScraper.arvutaKeskmineHind())
				.isGreaterThan(200_000)
				.isLessThan(300_000);
	}
	
	@Test
	void hind() {
		Assertions.assertThat(kvScraper.hind("125 000 €\n4 562 €/m²\nKuumakse 610 €")).isEqualTo(125_000);
	}
	
}
