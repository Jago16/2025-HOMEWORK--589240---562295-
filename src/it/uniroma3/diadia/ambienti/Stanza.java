package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;

	private Set<Attrezzo> attrezzi; 
	private Map<String, Stanza> stanzeAdiacenti; 


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new HashSet<Attrezzo>();
	}

	/**
	 * Imposta una stanza adiacente. Se la direzione contiene gia una stanza, aggiorna 
	 * la stanza situata in quella direzione (eg. 'sud'); altrimenti aggiunge
	 * sia la direzione che la relativa stanza agli array direzioni e stanze adiacenti.
	 * aggiorna infine il numero stanze adiacenti;
	 * 
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo
	 *                  parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		//guardia per assicurarsi la direzione sia corretta
		String[] dirPossibili = {"nord", "sud", "est", "ovest"};
		if(!Arrays.asList(dirPossibili).contains(direzione)) {
			return;
		}
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	
	public Map<String, Stanza> getStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		Stanza that = (Stanza)o;
		return this.nome.equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() * 31;
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			if (direzione != null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo a: this.attrezzi) {
			risultato.append(a.toString() + " ");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null) return false;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) return true; 
		}
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null) return null;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) return a;
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo wanted) {
		if(wanted == null) return false;
		return this.attrezzi.remove(wanted);
	}


}