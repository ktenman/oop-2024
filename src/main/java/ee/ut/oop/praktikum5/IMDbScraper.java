package ee.ut.oop.praktikum5;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class IMDbScraper {
	
	private static final String URL = "https://www.imdb.com";
	private static final String OTSINGU_URL = URL + "/find?q=";
	private final String filmiPealkiri;
	
	public IMDbScraper(String filmiPealkiri) {
		if (filmiPealkiri == null || filmiPealkiri.isEmpty()) {
			throw new IllegalArgumentException("Filmi pealkiri ei tohi olla tühi");
		}
		this.filmiPealkiri = filmiPealkiri;
	}
	
	public String getImdbRating() {
		try {
			Document document = Jsoup.connect(OTSINGU_URL + this.filmiPealkiri).get();
			Element element = document.selectFirst("li a");
			String href = element.attr("href");
			document = Jsoup.connect(URL + href).get();
			element = document.selectFirst("[data-testid=\"hero-rating-bar__aggregate-rating__score\"]");
			if (element == null) {
				throw new RuntimeException("IMDb rating ei leitud filmile: " + filmiPealkiri);
			}
			return element.text();
		} catch (IOException e) {
			throw new RuntimeException("IMDb ratingu leidmine ebaõnnestus", e);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Sisesta filmi pealkiri või 'exit' lõpetamiseks");
			String sisend = scanner.nextLine();
			if (sisend.equals("exit")) {
				break;
			}
			IMDbScraper scraper = new IMDbScraper(sisend);
			System.out.println(scraper.getImdbRating());
		}
	}
	
}
