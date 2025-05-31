package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public int getSogliaMagica() {
		return sogliaMagica;
	}

	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica;
	}

	public StanzaMagica(String nome) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		boolean posato = false;
		if(this.contatoreAttrezziPosati>=this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
			posato = super.addAttrezzo(attrezzo);
			if(posato==true) {
				this.contatoreAttrezziPosati++;
			}
		}
		else {
			posato=super.addAttrezzo(attrezzo);
			if(posato==true) {
				this.contatoreAttrezziPosati++;
			}
		}
		return posato;
	}
	/*
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
}
