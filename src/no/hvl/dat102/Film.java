package no.hvl.dat102;

public class Film extends Object {

	private int filmNr;
	private String filmSkaper;
	private String tittel;
	private int lanseringsAr;
	private Sjanger sjanger;
	private String filmSelskap;

	public Film() {
	}

	public Film(int filmNr, String filmSkaper, String tittel, int lanseringsAr, Sjanger sjanger, String filmSelskap) {
		this.filmNr = filmNr;
		this.filmSkaper = filmSkaper;
		this.tittel = tittel;
		this.lanseringsAr = lanseringsAr;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
	}

	public int getFilmNr() {
		return this.filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getFilmSkaper() {
		return this.filmSkaper;
	}

	public void setFilmSkaper(String filmSkaper) {
		this.filmSkaper = filmSkaper;
	}

	public String getTittel() {
		return this.tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsAr() {
		return this.lanseringsAr;
	}

	public void setLanseringsAr(int lanseringsAr) {
		this.lanseringsAr = lanseringsAr;
	}

	public Sjanger getSjanger() {
		return this.sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmSelskap() {
		return this.filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	public boolean equals(Film film) {
		return this.filmNr == film.getFilmNr();
	}

	@Override
	public int hashCode() {
		Integer temp = this.filmNr;
		return temp.hashCode();
	}

	@Override
	public String toString() {
		return "{" + " filmNr='" + getFilmNr() + "'" + ", filmSkaper='" + getFilmSkaper() + "'" + ", tittel='"
				+ getTittel() + "'" + ", lanseringsAr='" + getLanseringsAr() + "'" + ", sjanger='" + getSjanger() + "'"
				+ ", filmSelskap='" + getFilmSelskap() + "'" + "}";
	}
}
