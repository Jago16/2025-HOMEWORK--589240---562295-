package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IOSimulator implements IO {
	
	private List<String> righeDaLeggere;
	private int indiceRigheDaLeggere;
	private List<String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeDaLeggere = new CopyOnWriteArrayList<>(righeDaLeggere);
		this.indiceRigheDaLeggere = 0;
		this.messaggiProdotti = new ArrayList<>();
		this.indiceMessaggiProdotti = 0;
		this.indiceMessaggiMostrati = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
		this.indiceMessaggiProdotti++;

	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere.get(indiceRigheDaLeggere);
		indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(this.indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
}
