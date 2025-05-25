package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO console;
	

	public Partita() {
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.finita = false;
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public String toString() {
		return this.labirinto.getStanzaCorrente() + "hai " + this.giocatore.getCfu() + " cfu rimanenti";
	}

	public IO getConsole() {
		return this.console;
	}

	public void setConsole(IO console) {
		this.console = console;
	}
}
