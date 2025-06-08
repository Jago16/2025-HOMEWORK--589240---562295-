package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Giocatore: ha la responsabilità di gestire i CFU del giocatore e di memorizzare gli attrezzi in un oggetto istanza della classe
 * @see Borsa
 * @see Partita
 * @see Attrezzo
 * @version base 
 * */
public class Giocatore {

	static final private int CFU_INIZIALI = 20;

	private int cfu;
	private Borsa borsa;

	/*
	 * costruttore della classe Giocatore
	 * imposta come cfu del giocatore i cfu iniziali e crea una nuova borsa vuota
	 * */
	public Giocatore(){
		this.cfu=CFU_INIZIALI;
		this.borsa=new Borsa();
	}

	/*
	 * metodo che serve per ottenere il numero di cfu del giocatore
	 * @return ritorna un intero che 
	 * */
	public int getCfu() {
		return this.cfu;
	}

	/**
	 * Metodo che restituisce i cfu del giocatore
	 * @param cfu del giocatore
	 */
	public void setCfu(int cfu) {
		this.cfu=cfu;
	}

	/**
	 * Metodo che inserisce un attrezzo in borsa
	 * @param attrezzo da inserire in borsa
	 * @return boolean: True --> Inserimento andato a buon fine, False --> Inserimeno non andato a buon fine
	 */
	public boolean mettiInBorsa(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}

	public Borsa getBorsa() {
		return this.borsa;
	}

}