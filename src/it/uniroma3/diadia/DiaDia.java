package uniroma3.diadia;

import uniroma3.diadia.giocatore.giocatore;
import uniroma3.diadia.giocatore.borsa;


import java.util.Scanner;

import uniroma3.diadia.Partita;
import uniroma3.diadia.ambienti.Labirinto;
import uniroma3.diadia.ambienti.Stanza;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.comandi.Comando;
import uniroma3.diadia.comandi.FabbricaDiComandi;
import uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa" };

	private Partita partita;

	private giocatore giocatore;
	
	private Labirinto labirinto;
	
	public IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.giocatore = new giocatore();
		this.labirinto = this.partita.getLabirinto();
		this.io = io;
	}

	@SuppressWarnings("resource")
	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

		io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}

	// implementazioni dei comandi dell'utente:
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		//
	Stanza prossimaStanza = this.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu - 1);	
		}
		io.mostraMessaggio(labirinto + "\nCfu = " + this.giocatore.getCfu());
	}
	
	public void prendi(String nomeAttrezzo) {
		
		if(labirinto.getStanzaCorrente() == null) {
			io.mostraMessaggio("Errore: stanza corrente non valida.");
			return;
		}
		
		if (!labirinto.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
	        io.mostraMessaggio("Errore: attrezzo non trovato nella stanza.");
	        return;
	    }

		
		Attrezzo a = labirinto.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		labirinto.getStanzaCorrente().removeAttrezzo(a);
		
		if(!giocatore.getBorsa().addAttrezzo(a)) {
			io.mostraMessaggio("Borsa piena!");
			return;
		}
		else {
			giocatore.getBorsa().addAttrezzo(a);
			io.mostraMessaggio("Hai preso l'attrezzo: " + a.getNome());
		}
	}
	
	public void posa(String nomeAttrezzo) {
		
		if (!giocatore.getBorsa().hasAttrezzo(nomeAttrezzo)) {
	        io.mostraMessaggio("Errore: Non hai questo attrezzo nella borsa.");
	        return;
	    }
		
		Attrezzo a = giocatore.getBorsa().getAttrezzo(nomeAttrezzo);
		giocatore.getBorsa().removeAttrezzo(a);
		
		if(labirinto.getStanzaCorrente() == null) {
			 io.mostraMessaggio("Errore: La stanza non e' valida.");
		     return;
		}
		
		labirinto.getStanzaCorrente().addAttrezzo(a);
		io.mostraMessaggio("Hai posato l'attrezzo: " + a.getNome());
	}
	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/

	public static void main(String[] argc){
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
	
}