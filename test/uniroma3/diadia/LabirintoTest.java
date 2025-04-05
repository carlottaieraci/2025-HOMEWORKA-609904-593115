package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.ambienti.Labirinto;
import uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaCorrente;

	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.labirinto.setStanzaCorrente(stanzaCorrente);
		
	}
	

	@Test
	void testSetStanzaCorrenteNull() {
		labirinto.setStanzaCorrente(null);
		assertEquals(null, labirinto.getStanzaCorrente());
	}
	
	
	
	@Test
	void testGetStanzaCorrente() {
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}
	

	@Test
	void testGetStanzaCorrenteNull() {
		assertNull(labirinto.getStanzaCorrente());
	}
	
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	void testGetStanzaVincenteNotNull() {
		assertNotNull(labirinto.getStanzaVincente());
	}
}
