package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.ambienti.StanzaBuia;
import uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia stanzabuia;
	private String nomeAttrezzo = "computer";
	private String descrizione;
	private Attrezzo attrezzo;
	private Stanza stanzaPrima;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanzabuia = new StanzaBuia("Laboratorio Campus", "est", nomeAttrezzo);
		this.attrezzo = new Attrezzo(nomeAttrezzo, 2);
		this.stanzaPrima = new Stanza("atrio");
		stanzabuia.impostaStanzaAdiacente("ovest", stanzaPrima);
	}

	@Test
	void getDescrizioneNoAttrezzotest() {
		descrizione = stanzabuia.getDescrizione();
		assertTrue(descrizione.contains("qui c'è buio pesto"));
	}
	
	@Test
	void getDescrizioSiAttrezzotest() {
		stanzabuia.addAttrezzo(attrezzo);
		descrizione = stanzabuia.getDescrizione();
		assertFalse(descrizione.contains("qui c'è buio pesto"));
	}

}
