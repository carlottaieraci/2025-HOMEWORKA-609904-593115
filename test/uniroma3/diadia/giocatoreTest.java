package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import uniroma3.diadia.giocatore.giocatore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class giocatoreTest {
	
	private giocatore giocatore;
	
	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new giocatore();
	}

	@Test
	void testGetCfu() {
		assertEquals(20, this.giocatore.getCfu());
	}
	
	void testGetCfuNonNull() {
		assertNotNull(this.giocatore.getCfu());
	}
	@Test
	void testSetCfu() {
		giocatore.setCfu(17);
		assertEquals(17, giocatore.getCfu());
	}
	
	@Test
	void testGetBorsaNonNull() {
		assertNotNull(this.giocatore.getBorsa());
	}

}
