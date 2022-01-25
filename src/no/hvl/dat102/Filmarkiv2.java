package no.hvl.dat102;

import java.util.ArrayList;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		this.antall = 0;
		this.start = null;
	}

	@Override
	public void visFilm(int nr) {
		LinearNode<Film> curr = this.start;
		while (curr != null) {
			if (nr == curr.getElement().getFilmNr()) {
				System.out.println(curr.getElement().toString());
				return;
			}
			curr = curr.getNext();
		}
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (this.start == null) {
			this.start = new LinearNode<Film>(nyFilm);
			this.antall++;
			return;
		}
		
		LinearNode<Film> curr = this.start;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}

		curr.setNext(new LinearNode<Film>(nyFilm));
		this.antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (this.start == null) {
			return false;
		}

		LinearNode<Film> prev = null;
		LinearNode<Film> curr = this.start;
		while (curr.getElement().getFilmNr() != filmnr && curr.getNext() != null) {
			prev = curr;
			curr = curr.getNext();
		}

		if (curr.getElement().getFilmNr() != filmnr) {
			return false;
		}

		if (prev == null) {
			this.start = curr.getNext();
			this.antall--;
			return true;
		}

		prev.setNext(curr.getNext());
		this.antall--;
		return true;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> matcher = new ArrayList<Film>();

		LinearNode<Film> curr = this.start;
		while (curr != null) {
			if (curr.getElement().getTittel().contains(delstreng)) {
				matcher.add(curr.getElement());
			}
			curr = curr.getNext();
		}

		Film[] arr = new Film[matcher.size()];
		arr = matcher.toArray(arr);
		return arr;
	}

	@Override
	public Film[] soekFilmprodusent(String delstreng) {
		ArrayList<Film> matcher = new ArrayList<Film>();

		LinearNode<Film> curr = this.start;
		while (curr != null) {
			if (curr.getElement().getFilmSkaper().contains(delstreng)) {
				matcher.add(curr.getElement());
			}
			curr = curr.getNext();
		}

		Film[] arr = new Film[matcher.size()];
		arr = matcher.toArray(arr);
		return arr;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int counter = 0;
		LinearNode<Film> curr = this.start;
		while (curr != null) {
			if (sjanger == curr.getElement().getSjanger()) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public int antall() {
		return this.antall;
	}

}
