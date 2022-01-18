package no.hvl.dat102;

import java.util.ArrayList;

import no.hvl.dat102.adt.*;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmer;
	private int antall;

	public Filmarkiv(int antallFilmer) {
		this.filmer = new Film[antallFilmer];
		this.antall = 0;
	}

	public void visFilm(int nr) {
		int idx = finn(nr);
		if (idx < 0) {
			return;
		}

		Film f = this.filmer[idx];
		System.out.println(f.toString());
	}

	public void leggTilFilm(Film nyFilm) {
		if (!harPlass()) {
			utvid();
		}

		this.filmer[this.antall] = nyFilm;
		this.antall++;
	}

	public boolean slettFilm(int filmnr) {
		int idx = finn(filmnr);
		if (idx < 0) {
			return false;
		}

		if (idx < this.antall - 1) {
			System.arraycopy(this.filmer, idx, this.filmer, idx - 1, this.antall - idx - 1);
		}

		this.filmer[idx] = null;
		this.antall--;

		return true;
	}

	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> matcher = new ArrayList<Film>();

		for (int i = 0; i < this.antall; i++) {
			if (this.filmer[i].getTittel().contains(delstreng)) {
				matcher.add(this.filmer[i]);
			}
		}

		Film[] arr = new Film[matcher.size()];
		arr = matcher.toArray(arr);
		return arr;
	}

	public Film[] soekFilmprodusent(String delstreng) {
		ArrayList<Film> matcher = new ArrayList<Film>();

		for (int i = 0; i < this.antall; i++) {
			if (this.filmer[i].getFilmSkaper().contains(delstreng)) {
				matcher.add(this.filmer[i]);
			}
		}

		Film[] arr = new Film[matcher.size()];
		arr = matcher.toArray(arr);

		return arr;
	}

	public int antall(Sjanger sjanger) {
		int counter = 0;
		for (int i = 0; i < this.antall; i++) {
			if (sjanger == this.filmer[i].getSjanger()) {
				counter++;
			}
		}

		return counter;
	}

	public int antall() {
		return this.antall;
	}

	// Sjekker om det er plass
	private boolean harPlass() {
		return this.antall < this.filmer.length;
	}

	// Utvider tabellen
	private void utvid() {
		Film[] ny = new Film[this.filmer.length * 2];

		for (int i = 0; i < this.antall; i++) {
			ny[i] = this.filmer[i];
		}

		this.filmer = ny;
	}

	// Finner index til en film gitt ved filmnr
	private int finn(int filmnr) {
		for (int i = 0; i < this.antall; i++) {
			if (filmnr == this.filmer[i].getFilmNr()) {
				return i;
			}
		}

		return -1;
	}
}
