package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorPerPeso implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int cmp=a1.getPeso()-a2.getPeso();
		if(cmp==0)
			cmp=a1.getNome().compareTo(a2.getNome());
		return cmp;
	}

}
