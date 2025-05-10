package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.ambienti.StanzaBloccata;
import uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaDopo;
	private Attrezzo attrezzoSbloccante;
	private String descrizione;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBloccata= new StanzaBloccata("aulaN10","sud","lanterna");
		this.stanzaDopo = new Stanza("biblioteca");
		this.stanzaBloccata.impostaStanzaAdiacente("sud", stanzaDopo);
		this.attrezzoSbloccante = new Attrezzo("lanterna",20);
	}

	@Test
	void getStanzaAdiacenteNoAttrezzoTest() {
		assertEquals(stanzaBloccata,stanzaBloccata.getStanzaAdiacente("sud"));
	}
	
	
	@Test
	void getStanzaAdiacenteSiAttrezzoTest() {
		stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanzaDopo,stanzaBloccata.getStanzaAdiacente("sud"));
	}
	
	@Test
	void getDescrizioneNoAttrezzoTest() {
		descrizione = stanzaBloccata.getDescrizione();
		assertTrue(descrizione.contains("\nAttualmente la direzione 'sud' è bloccata. Serve di posare l'attrezzo 'lanterna' per sbloccarla."));
	}
	
	@Test
	void getDescrizioneSiAttrezzoTest() {
		stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		descrizione = stanzaBloccata.getDescrizione();
		assertFalse(descrizione.contains("\nAttualmente la direzione '" + "' è bloccata. " +
	               "Serve l'attrezzo '" + "' per sbloccarla."));
	}
	

}
