package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledig = 0;

	public Blogg() {
		this.innleggstabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggstabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return this.nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int i = 0;
		boolean found = false;
		while (!found && i < this.getAntall()) {
			if (innleggstabell[i].erLik(innlegg)) {
				found = true;
			} else {
				i++;
			}
		}
		
		return !found ? -1 : i;
	}

	public boolean finnes(Innlegg innlegg) {
		return this.finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return this.getAntall() < innleggstabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (this.ledigPlass()) {
			this.innleggstabell[this.nesteledig] = innlegg;
			this.nesteledig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String output = Integer.toString(this.getAntall()) + "\n";
		
		for (int i = 0; i < this.getAntall(); i++) {
			output += innleggstabell[i].toString();
		}
		
		return output;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] temp = new Innlegg[this.innleggstabell.length + 1];
		
		for (int i = 0; i < temp.length-1; i++) {
			temp[i] = this.innleggstabell[i];
		}
		
		this.innleggstabell = temp;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		this.utvid();
		if (this.ledigPlass()) {
			this.leggTil(innlegg);
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		if (this.finnes(innlegg)) {
			this.innleggstabell[this.finnInnlegg(innlegg)] = this.innleggstabell[this.nesteledig-1];
			this.innleggstabell[this.nesteledig-1] = null;
			this.nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}