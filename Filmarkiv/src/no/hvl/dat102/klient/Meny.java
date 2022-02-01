package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		Film filmEn = new Film(1, "Arne Arnesen Sr.", "Death på programeringslabben", 1638, Sjanger.ROMANCE,
				"Java Films Studio");
		Film filmTo = new Film(5, "Arne Arnesen Sr.", "Death på programeringslabben II", 1639, Sjanger.SCIFI,
				"Java Films Studio");
		Film filmTre = new Film(57, "Arne Arnesen Jr.", "Death på programeringslabben III", 1640, Sjanger.FANTASY,
				"Java Films Studio");
		Film filmFire = new Film(23, "Arne Arnesen Jr.", "Death på programeringslabben IV", 1641, Sjanger.COMEDY,
				"Java Films Studio");
		Film filmFem = new Film(25, "Arne Arnesen Jr.", "Death på programeringslabben V", 1642, Sjanger.ROMANCE,
				"Java Films Studio");
		Film filmSeks = new Film(46, "Arne Arnesen III", "Reborn Programeringslabben", 1643, Sjanger.HORROR,
				"Java Films Studio");
		Film filmSyv = new Film(38, "Arne Arnesen III", "World's end", 1644, Sjanger.ROMANCE, "Java Films Studio");

		this.filmarkiv.leggTilFilm(filmEn);
		this.filmarkiv.leggTilFilm(filmTo);
		this.filmarkiv.leggTilFilm(filmTre);
		this.filmarkiv.leggTilFilm(filmFire);
		this.filmarkiv.leggTilFilm(filmFem);
		this.filmarkiv.leggTilFilm(filmSeks);
		this.filmarkiv.leggTilFilm(filmSyv);

		this.filmarkiv.leggTilFilm(tekstgr.lesFilm());

		System.out.println(this.filmarkiv.toString());
	}
}
