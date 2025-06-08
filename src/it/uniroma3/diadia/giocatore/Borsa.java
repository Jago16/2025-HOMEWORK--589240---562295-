package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorPerPeso;

/**
 * Borsa:classe che contiene un certo numero di attrezzi posseduti dal giocatore
 * usata per aggiungere un attrezzo nella borsa, rimuovere un oggetto dalla borsa, sapere il peso della borsa
 * @see Giocatore
 * @see Attrezzo
 * @version base 
 * */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() { this(DEFAULT_PESO_MAX_BORSA);
	}

	/*
	 * costruttore della classe borsa
	 * @param pesoMax è il peso massimo di oggetti che si possono ancora aggiungere nella borsa
	 * */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String,Attrezzo>();
	}


	/*
	 * metodo che serve per aggiungere un attrezzo nella borsa
	 * @param attrezzo è l'oggetto attrezzo che vogliamo inserire
	 * @return ritorna un valore booleano che è true se l'oggetto è stato inserito, false altrimenti
	 * */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;

		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		this.attrezzi.put(attrezzo.getNome(),attrezzo);
		return true;
	}

	/*
	 * metodo che serve per ottenere il peso disponibile nella borsa
	 * @return pesoMax
	 * */
	public int getPesoMax() {
		return this.pesoMax;
	}

	/*
	 * metodo che serve per ottenere l'attrezzo di nome nomeAttrezzo nella borsa
	 * @param nomeAttrezzo è il nome dell'attrezzo che stavamo cercando
	 * @return ritorna a che è il riferimento all'attrezzo che stavamo cercando, altrimenti è null
	 * */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/*
	 * metodo che serve per ottenere il peso totale degli oggetti nella borsa
	 * @return pesoMax
	 * */
	public int getPeso() {
		int peso = 0;
		Collection<Attrezzo> attrezzi= this.attrezzi.values();
		for(Attrezzo a : attrezzi)
			peso+=a.getPeso();
		return peso;
	}


	/*
	 * metodo che ci dice se la borsa è vuota
	 * @return un valore boolano che è true se la borsa è vuota, è false altrimenti
	 * */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/*
	 * metodo che serve per sapere se nella borsa abbiamo un attrezzo con un certo nome
	 * @param nomeAttrezzo è il nome dell'attrezzo che vogliamo cercare
	 * @return un valore booleano che è true se l'attrezzo è presente nella borsa, è false altirmenti
	 * */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/*
	 * metodo che rimuove un attrezzo con un dato nome
	 * @param nomeAttrezzo è il nome dell'attrezzo che vogliamo rimuovere
	 * @return a che è un riferimento all'attrezzo appena rimosso, altrimenti è null
	 * */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getAttrezzo(nomeAttrezzo);
		this.attrezzi.remove(nomeAttrezzo);
		return a;
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		if(this.attrezzi.size()==0||this.attrezzi==null)		//Sentinella
			return null;

		final List<Attrezzo> lista = new ArrayList<Attrezzo>(this.attrezzi.values());
		Collections.sort(lista,new ComparatorPerPeso());
		return lista;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		if(this.attrezzi.size()==0||this.attrezzi==null)		//Sentinella
			return null;

		final SortedSet<Attrezzo> ordinato= new TreeSet<Attrezzo>(this.attrezzi.values());
		return ordinato;
	}


	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		if(this.attrezzi.size()==0||this.attrezzi==null)		//Sentinella
			return null;

		Set<Attrezzo> temp;
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		List<Attrezzo> attrezzi = new ArrayList<Attrezzo>(this.attrezzi.values());
		for(Attrezzo a : attrezzi) {
			temp=mappa.get(a.getPeso());
			if(temp==null) {
				temp=new HashSet<Attrezzo>();
				mappa.put(a.getPeso(), temp);
			}
			temp.add(a);
		}
		return mappa;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		if(this.attrezzi.size()==0||this.attrezzi==null)		//Sentinella
			return null;

		ComparatorPerPeso cmp = new ComparatorPerPeso();
		SortedSet<Attrezzo> ordinato = new TreeSet<Attrezzo>(cmp);
		ordinato.addAll(this.attrezzi.values());
		return ordinato;
	}
	/*
	 * metodo che ci restituisce informazioni sulla borsa quali nomi e peso degli attrezzi nella borsa,il peso totale degli attrezzi, il peso disponibile nella borsa
	 * @return una stringa contenente le informazioni della borsa
	 * */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (this.isEmpty()) {
			s.append("Borsa vuota");
		} else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): [");
			List<Attrezzo> attrezzi = this.getContenutoOrdinatoPerPeso();
			for (Attrezzo a : attrezzi)
				s.append(a.toString()+", ");
			s.setLength(s.length()-2);
			s.append("]");
		}
		return s.toString();
	}
}