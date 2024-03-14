package ee.ut.oop.praktikum5.imdb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * IMDbScraper on klass, mis võimaldab otsida IMDb-st filmi reitingut.
 * Klassi konstruktor võtab argumendiks filmi pealkirja ja otsib sellele vastavat IMDb reitingut.
 */
public class IMDbScraper {
	
	private static final String URL = "https://www.imdb.com";
	private static final String OTSINGU_URL = URL + "/find?q=";
	private String filmiPealkiri;
	private String imdbRating;
	
	public IMDbScraper(String filmiPealkiri) {
		this.filmiPealkiri = filmiPealkiri;
		otsiReitingut();
	}
	
	public IMDbScraper() {
	}
	
	public String getImdbRating() {
		return imdbRating;
	}
	
	public void setFilmiPealkiri(String filmiPealkiri) {
		this.filmiPealkiri = filmiPealkiri;
	}
	
	/**
	 * Otsib filmi IMDb reitingut.
	 */
	public void otsiReitingut() {
		if (this.filmiPealkiri == null || this.filmiPealkiri.isEmpty()) {
			throw new IllegalArgumentException("Filmi pealkiri ei tohi olla tühi");
		}
		try {
			Document document = Jsoup.connect(OTSINGU_URL + this.filmiPealkiri).get();
			Element element = document.selectFirst("li a");
			String href = element.attr("href");
			document = Jsoup.connect(URL + href).get();
			element = document.selectFirst("[data-testid=\"hero-rating-bar__aggregate-rating__score\"]");
			if (element == null) {
				throw new RuntimeException("IMDb rating ei leitud filmile: " + filmiPealkiri);
			}
			this.imdbRating = element.text();
		} catch (IOException e) {
			throw new RuntimeException("IMDb ratingu leidmine ebaõnnestus", e);
		}
	}
	
	
}
