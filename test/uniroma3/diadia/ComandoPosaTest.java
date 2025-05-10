package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.IO;
import uniroma3.diadia.IOConsole;
import uniroma3.diadia.Partita;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {
	
	private ComandoPosa posa;
	private IO io;
	private Attrezzo osso;
	private String nomeAttrezzo = "osso";
	private Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.posa = new ComandoPosa(this.io);
		this.partita = new Partita();
		this.osso = new Attrezzo(nomeAttrezzo,5);
	}

	@Test
	void attrezzoStanzaNullTest() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
		posa.setParametro(nomeAttrezzo);
		this.partita.getLabirinto().setStanzaCorrente(null);
		posa.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo));
	}
	
	@Test
	void attrezzoNonRimossoTest() {
		posa.setParametro("martello");
		posa.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	void attrezzoRimossoTest() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
		posa.setParametro(nomeAttrezzo);
		posa.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo));
	}
	

}
