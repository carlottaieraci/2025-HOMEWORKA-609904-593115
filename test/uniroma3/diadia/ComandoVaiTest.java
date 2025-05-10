package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.IO;
import uniroma3.diadia.IOConsole;
import uniroma3.diadia.Partita;
import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {
	
	private ComandoVai comando;
	private  IO io;
	private Partita partita;
	private String direzione = "est";
	private Stanza stanzaCorrente;
	private Stanza stanzaAdiacente;
	private int cfu;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole();
		comando = new ComandoVai(this.io, this.direzione);
		partita = new Partita();
		stanzaCorrente = partita.getStanzaCorrente();
		stanzaAdiacente = new Stanza("laboratorio");
		stanzaCorrente.impostaStanzaAdiacente(direzione,stanzaAdiacente);
		cfu = partita.getGiocatore().getCfu();
	}
	
	/*@Test
	void direzioneNonEsistenteTest() {
		
		comando.setParametro("sud");
		comando.esegui(partita);
		assertSame(stanzaCorrente , partita.getStanzaCorrente());
		
	}*sbagliato*/
	

	@Test
	void controllaDirezioneTest() {
		
		comando.setParametro(direzione);
		comando.esegui(partita);
		assertEquals("laboratorio",partita.getStanzaCorrente().getNome());
		
	}
	
	@Test
	void cfuDiminuitiTest() {
		cfu = partita.getGiocatore().getCfu();
		comando.setParametro(direzione);
		comando.esegui(partita);
		
		assertEquals(cfu - 1, partita.getGiocatore().getCfu());
		
	}
	
	

}
