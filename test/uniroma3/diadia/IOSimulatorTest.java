package uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	
	private IO ioSim;
	private String[] comandi = {
			"guarda", //dove si trova
			"vai ovest", //laboratorio
			"vai nord", //aula N9, non puoi andare a ovest, torni indietro
			"vai sud", //torna in laboratorio
			"vai est", //atrio
			"vai est", //aula N11
			"prendi chiave",
			"vai est", //laboratorio
			"vai nord", //Aula N9
			"posa chiave", //sblocca la direzione del bagno (ovest)
			"vai ovest", //bagno, stanza buia! torno indietro
			"vai est", //aula N9
			"vai sud", // laboratorio
			"vai est", //atrio
			"vai sud", //aula N10
			"prendi lanterna", 
			"vai ovest", //laboratorio
			"vai nord", //aula N9
			"vai ovest", //bagno
			"posa lanterna", //luce in bagno
			"vai ovest", //biblioteca. hai vinto!
			"fine"
	};
	private DiaDia gioco;

	@BeforeEach
	void setUp() throws Exception {
		this.ioSim = new IOSimulator(this.comandi);
		this.gioco = new DiaDia(this.ioSim);
	}

	@Test
	void testPartitaCompletaVinci() {
		gioco.gioca();
		String[] output =((IOSimulator) ioSim).getDaStampare();
		boolean vinta = false;
		for(int i=0; i<output.length; i++) {
			if(output[i]!=null && output[i].equals("Hai vinto!")) {
				vinta = true;
				break;
			}
		}
		assertTrue(vinta);
	}

}
