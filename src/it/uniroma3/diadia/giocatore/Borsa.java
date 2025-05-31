package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.attrezzi.size() == 10)
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if (nomeAttrezzo == null)
			return null;
		for (Attrezzo a : this.attrezzi) {
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a: this.attrezzi) {
			if (a.getNome().equals(nomeAttrezzo)) {
				this.attrezzi.remove(a);
				return a;
			}
		}
		return null;
	}

		public String toString() {
			StringBuilder s = new StringBuilder();
			if (!this.isEmpty()) {
				s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
				for (int i = 0; i < this.numeroAttrezzi; i++)
					s.append(attrezzi[i].toString() + " ");
			} else
				s.append("Borsa vuota");
			return s.toString();
		}
	}
