package uniroma3.diadia;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.ambienti.Labirinto;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.giocatore.giocatore;


public class Partita {

	/*private Stanza stanzaCorrente;
	private Stanza stanzaVincente;*/
	private boolean finita;
	/*private int cfu;*/
	private giocatore giocatore;
	
	private Labirinto labirinto;
	
	public Partita(){
		/*creaStanze();*/
		this.finita = false;
		/*this.cfu = CFU_INIZIALI; */
		this.labirinto = new Labirinto();
	}
	
	
    /**
     * Crea tutte le stanze e le porte di collegamento
     */
   
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	
	public Labirinto getLabirinto() {
	    return this.labirinto;
	}
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore!=null && giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/*public int getCfu() {
		return this.cfu;
	}*/// da togliere
	

	/*public void setCfu(int cfu) {
		this.cfu = cfu;		
	}*/	// da togliere
	
	/*public String toString() {
		return this.labirinto.getStanzaCorrente().toString();
	}*/
}
