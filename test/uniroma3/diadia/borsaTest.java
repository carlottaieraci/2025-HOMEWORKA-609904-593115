package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.giocatore.borsa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class borsaTest {
	private borsa borsa;
	private Attrezzo osso;
	private Attrezzo ciao;
	private Attrezzo cane;
	private Attrezzo gatto;
	private Attrezzo pappa;
	private Attrezzo topo;
	private Attrezzo martello;
	private Attrezzo penna;
	private Attrezzo pc;
	private Attrezzo ap;
	private Attrezzo tv;
	private borsa piena;
	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new borsa();
		this.osso = new Attrezzo("osso", 98);
		this.ciao = new Attrezzo("ciao", 1);
		this.cane = new Attrezzo("cane", 1);
		this.gatto = new Attrezzo("gatto", 8);
		this.pappa = new Attrezzo("pappa", 1);
		this.topo = new Attrezzo("topo", 1);
		this.martello = new Attrezzo("martello", 1);
		this.penna = new Attrezzo("penna", 1);
		this.pc = new Attrezzo("pc", 1);
		this.tv = new Attrezzo("tv", 1);
		this.ap = new Attrezzo("ap", 1);
		this.piena = new borsa(470);
		piena.addAttrezzo(gatto);
		piena.addAttrezzo(ciao);
		piena.addAttrezzo(cane);
		piena.addAttrezzo(pappa);
		piena.addAttrezzo(topo);
		piena.addAttrezzo(martello);
		piena.addAttrezzo(penna);
		piena.addAttrezzo(pc);
		piena.addAttrezzo(tv);
		piena.addAttrezzo(ap);
		
	}

	@Test
	void testAddAttrezzoPesoMax() {
		assertFalse(borsa.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzoAttrezziMax() {
		assertFalse(piena.addAttrezzo(osso));
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(piena.hasAttrezzo("tv"));
	}
	
	@Test
	void testHasntAttrezzo() {
		assertFalse(borsa.hasAttrezzo("tv"));
	}
	
	@Test
	void testAddAttrezzo() {
		borsa.addAttrezzo(tv);
		assertTrue(borsa.hasAttrezzo("tv"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertTrue(piena.removeAttrezzo(ap));
		assertFalse(piena.hasAttrezzo("ap"));
	}
	
	@Test
	void testRemoveAttrezzoFalse() {
		assertFalse(borsa.removeAttrezzo(ap));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertNull(borsa.getAttrezzo("ap"));
	}
	
	@Test
	void testGetAttrezzo() {
		assertEquals(tv,piena.getAttrezzo("tv"));
	}
	
	@Test
	void testgetPeso() {
		assertEquals(17, piena.getPeso());
	}
	
	@Test
	void testgetPesoMax() {
		assertEquals(470, piena.getPesoMax());
	}
}
