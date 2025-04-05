package uniroma3.diadia.giocatore;

import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.attrezzi.Attrezzo;

public class borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	
	public borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
		
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/*public Attrezzo removeAttrezzo1(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i=0;i<this.numeroAttrezzi ;i++) {
			if (this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				for(int j=i; j<this.numeroAttrezzi -1; j++)
						this.attrezzi[j]=this.attrezzi[j+1]; //ricuci la catena: sposti tutti gli elementi di una posizione
				
				this.attrezzi[numeroAttrezzi]=null; //l'ultimo elemento è doppio lo elimino
				attrezzi[i] = null;
				this.numeroAttrezzi--; //decremento la lunghezza dell'array
				return a;
				}
		}
		return null; //non ho trovato l'elemento
	}
	*/
	
	public boolean removeAttrezzo(Attrezzo a) {
		
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i] == a) {
				this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi-1];
				this.attrezzi[this.numeroAttrezzi-1] = null; // non indispendabile
				this.numeroAttrezzi--;
				return true;
				
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
			}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
