package ee.ut.oop.praktikum5.imdb;

import java.util.Random;
import java.util.Scanner;

public class Peaklass {
	
	private static final String[] FILMI_PEALKIRJAD = {"The Shawshank Redemption", "The Godfather", "The Dark Knight", "Pulp Fiction", "Fight Club"};
	private static final Random RANDOM = new Random();
	
	/**
	 * Main meetod, mis küsib kasutajalt, kas soovitakse sisestada filmi pealkiri käsitsi või saada juhusliku filmi IMDb hinnang.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Kas soovite sisestada filmi pealkirja käsitsi (k) või saada juhusliku (j)? Kirjutage 'exit', et lõpetada");
			String input = scanner.nextLine();
			if (input.equals("exit")) {
				break;
			} else if (input.equalsIgnoreCase("k")) {
				System.out.println("Sisestage filmi pealkiri:");
				String filmTitle = scanner.nextLine();
				IMDbScraper scraper = new IMDbScraper(filmTitle);
				System.out.println(filmTitle + " IMDb hinnang: " + scraper.getImdbRating());
			} else if (input.equalsIgnoreCase("j")) {
				String randomFilm = FILMI_PEALKIRJAD[RANDOM.nextInt(FILMI_PEALKIRJAD.length)];
				IMDbScraper scraper = new IMDbScraper();
				scraper.setFilmiPealkiri(randomFilm);
				scraper.otsiReitingut();
				System.out.println("Juhuslikult valitud film: " + randomFilm);
				System.out.println("IMDb hinnang: " + scraper.getImdbRating());
			} else {
				System.out.println("Vigane sisend. Palun sisestage 'k', 'j' või 'exit'");
			}
		}
		scanner.close();
	}
}
