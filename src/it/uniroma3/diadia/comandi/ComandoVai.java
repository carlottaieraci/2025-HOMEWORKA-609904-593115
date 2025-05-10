package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;
import uniroma3.diadia.ambienti.Labirinto;
import uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
		private String direzione;
		private  IO io;

	    

		public ComandoVai(IO io, String direzione) {
		this.direzione = direzione;
		this.io = io;
		}
		
		@Override
	    public String getNome() {
	    	return "vai";
	    }

		/**
		* esecuzione del comando
		*/
		@Override
		public void esegui(Partita partita) {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			Stanza prossimaStanza = null;
			if (direzione==null) {
			    io.mostraMessaggio("Dove vuoi andare?"
			    		+ " Devi specificare una direzione");
			    return;
			}
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
			if (prossimaStanza==null) {
				io.mostraMessaggio("Direzione inesistente");
			    return;
			}
			partita.setStanzaCorrente(prossimaStanza);
			/*io.mostraMessaggio(partita.getStanzaCorrente().getNome());*/
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		@Override
		 public void setParametro(String parametro) {
		     this.direzione = parametro;
		 }
		
		@Override
		public String getParametro() {
			return this.direzione;
		}

}
