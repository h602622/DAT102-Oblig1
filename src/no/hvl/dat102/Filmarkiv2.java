package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		this.antall = 0;
		this.start = new LinearNode<Film>();
	}

	@Override
	public void visFilm(int nr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film[] soekFilmprodusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
