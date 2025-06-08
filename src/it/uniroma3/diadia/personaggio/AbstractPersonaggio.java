package it.uniroma3.diadia.personaggio;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	protected Attrezzo attrezzo;
	
	public AbstractPersonaggio (String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		if(!this.haSalutato)
			risposta.append(this.presentazione);
		else
			risposta.append("Ci siamo già presentati!");
		this.haSalutato = true;
		return risposta.toString();
	}
	
	public void Salutato() {
		this.haSalutato = true;
	}
	
	public void setAttrezzo(Attrezzo attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	public Attrezzo getAttrezzo() {
		return this.attrezzo;
	}
	
	abstract public String agisci(Partita partita);
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	@Override
	public String toString() {
		return this.getNome() +" ha "+ this.getAttrezzo();
	}
	
}
