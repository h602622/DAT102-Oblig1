package no.hvl.dat102.klient;

import java.util.Scanner;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner sc = new Scanner(System.in);

		int filmnr = skaffNummer(sc, "Filmnr: ");
		String filmskaper = skaffString(sc, "Filmskaper: ");
		String tittel = skaffString(sc, "Tittel: ");
		int lansering = skaffNummer(sc, "Lansering: ");
		String filmselskap = skaffString(sc, "Filmselskap: ");

		for (Sjanger s : Sjanger.values()) {
			System.out.println(s.ordinal() + ") " + s.toString());
		}

		int sjangerSomInt;
		do {
			sjangerSomInt = skaffNummer(sc, "Velg sjanger fra lista: ");
		} while (sjangerSomInt < 0 || sjangerSomInt >= Sjanger.values().length);

		return new Film(filmnr, filmskaper, tittel, lansering, Sjanger.values()[sjangerSomInt], filmselskap);
	}

	private String skaffString(Scanner s, String prompt) {
		String str = "";
		while (str.equals("")) {
			System.out.print(prompt);
			str = s.nextLine();
		}

		return str;
	}

	private int skaffNummer(Scanner s, String prompt) {
		System.out.print(prompt);
		try {
			int number = Integer.parseInt(s.nextLine());
			return number;
		} catch (NumberFormatException e) {
			return skaffNummer(s, prompt);
		}
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		for (Film f : filma.soekTittel(delstreng)) {
			System.out.println(f.toString());
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		for (Film f : filma.soekFilmprodusent(delstreng)) {
			System.out.println(f.toString());
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Totalt:" + filma.antall());

		for (Sjanger s : Sjanger.values()) {
			System.out.println(s.toString() + " : " + filma.antall(s));
		}
	}
	// … Ev. andre metoder
}
