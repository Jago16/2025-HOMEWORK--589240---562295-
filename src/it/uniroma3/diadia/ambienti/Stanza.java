package it.uniroma3.diadia.ambienti;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 *  * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	private Map<String,Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new HashMap<String,Attrezzo>();
		this.nome = nome;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(this.stanzeAdiacenti.size()<4) {
			this.stanzeAdiacenti.put(direzione, stanza);
			return;
		}
		IO io = new IOConsole();
		io.mostraMessaggio("Direzione non disponibile, posso avere solo 4 direzioni");
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");

		Set<String> direzioni = this.getDirezioni();
		for (String direzione : direzioni)
			risultato.append(" " + direzione);

		risultato.append("\nAttrezzi nella stanza: ");
		Collection<Attrezzo> attrezzi = this.attrezzi.values();
		for (Attrezzo a : attrezzi) {
			risultato.append(a.toString()+" ");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param riferimento dell'attrezzo da rimuovere
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.remove(attrezzo.getNome())!=null)
			return true;
		return false;

	}


	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	public boolean isMagica() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if(o==null)
			return false;

		Stanza that = (Stanza)o;

		return this.getNome().equals(that.getNome());
	}

}