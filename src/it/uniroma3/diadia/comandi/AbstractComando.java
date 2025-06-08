package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{
	protected String parametro;
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getParametro() {
		return this.parametro;
	}
	
	public abstract String getNome();
	public abstract void esegui(Partita partita);
}