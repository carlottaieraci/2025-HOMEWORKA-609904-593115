package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.giocatore.giocatore;
import uniroma3.diadia.ambienti.Labirinto;
import uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	private Labirinto labirinto;
	private giocatore giocatore;
	private int cfu;
	
	@BeforeEach
	void setUp()  {
		this.partita = new Partita();
		new Stanza("biblioteca");
		this.labirinto = new Labirinto();
		this.giocatore = new giocatore();
		this.cfu = giocatore.getCfu();
	}
	

	@Test
	void testNuovaPartita_non_finita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testPartitaVinta() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	void testPartitaPersa() {
		/*this.partita.setCfu(0);*/
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testNuovaPartita_non_finita_poiFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}


}
