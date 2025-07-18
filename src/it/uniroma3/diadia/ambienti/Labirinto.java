package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> stanze;


	public Labirinto() {
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Labirinto(String test) {		//Costruttore usato unicamente nei test vecchi
		creaStanze();
	}

	private void creaStanze() {

		// crea gli attrezzi 
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		// pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}



	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public void setStanzaIniziale(Stanza stanza) {
		this.stanzaIniziale = stanza;
	}

	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}

	public Stanza getUltimaAggiunta() {
		return this.ultimaAggiunta;
	}

	public void setUltimaAggiunta(Stanza ultimaAggiunta) {
		this.ultimaAggiunta = ultimaAggiunta;
	}

	public Map<String,Stanza> getStanze() {
		return this.stanze;
	}
}
