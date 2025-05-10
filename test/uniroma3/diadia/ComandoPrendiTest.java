package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.IO;
import uniroma3.diadia.IOConsole;
import uniroma3.diadia.Partita;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	
	private ComandoPrendi prendi;
	private IO io;
	private Attrezzo ago;
	private String nomeAttrezzo = "ago";
	private Partita partita;


	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.prendi = new ComandoPrendi(this.io);
		this.partita = new Partita();
		this.ago = new Attrezzo(nomeAttrezzo,1);
	}

	@Test
	void attrezzoNullTest() {
		prendi.setParametro(null);
		prendi.esegui(this.partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void attrezzoPresoTest() {
		this.partita.getStanzaCorrente().addAttrezzo(ago);
		prendi.setParametro(nomeAttrezzo);
		prendi.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo));
	}

}
