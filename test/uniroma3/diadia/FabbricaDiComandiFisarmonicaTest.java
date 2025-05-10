package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniroma3.diadia.IO;
import uniroma3.diadia.IOConsole;
import uniroma3.diadia.comandi.Comando;
import uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	
	private IO io;
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	
	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.fabbrica = new FabbricaDiComandiFisarmonica(this.io);
	}

	@Test
	void comandoNonValidotest() {
		this.comando = fabbrica.costruisciComando("");
		assertEquals("nonvalido", comando.getNome());
	}
	
	@Test
	void comandoVaiNoParametroTest() {
		this.comando = fabbrica.costruisciComando("vai");
		assertEquals("vai",comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void comandoVaiSiParametroTest() {
		this.comando = fabbrica.costruisciComando("vai sud");
		assertEquals("vai",comando.getNome());
		assertEquals("sud",comando.getParametro());
	}
	
	@Test
	void comandoPrendiNoOggettoTest() {
		this.comando = fabbrica.costruisciComando("prendi");
		assertEquals("prendi",comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void comandoPrendiSiOggettoTest() {
		this.comando = fabbrica.costruisciComando("prendi pc");
		assertEquals("prendi",comando.getNome());
		assertEquals("pc",comando.getParametro());
	}
	
	@Test
	void comandoPosaNoOggettoTest() {
		this.comando = fabbrica.costruisciComando("posa");
		assertEquals("posa",comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void comandoPosaSiOggettoTest() {
		this.comando = fabbrica.costruisciComando("posa pc");
		assertEquals("posa",comando.getNome());
		assertEquals("pc",comando.getParametro());
	}
	
	@Test
	void comandoAiutotest() {
		this.comando = fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
	}
	
	@Test
	void comandoFinetest() {
		this.comando = fabbrica.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
	}
	
	@Test
	void comandoGuardatest() {
		this.comando = fabbrica.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
	}
}
