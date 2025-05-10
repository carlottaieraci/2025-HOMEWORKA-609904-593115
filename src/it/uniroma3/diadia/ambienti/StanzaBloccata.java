package uniroma3.diadia.ambienti;

import uniroma3.diadia.IO;
import uniroma3.diadia.IOConsole;

public class StanzaBloccata extends Stanza {
	
	private String direzione;
	private String nomeAttrezzo;
	
	public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
		super(nome);
		this.direzione = direzione;
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        
		if(this.direzione.equals(direzione) && !this.hasAttrezzo(nomeAttrezzo)) {
			this.getDescrizione();
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);
		
	}
	
	@Override
	public String getDescrizione() {
		
		if (!this.hasAttrezzo(this.nomeAttrezzo)) {
	        return super.getDescrizione() + "\nAttualmente la direzione '" + this.direzione + "' è bloccata. " +
	               "Serve di posare l'attrezzo '" + this.nomeAttrezzo + "' per sbloccarla.";
	    } 
		else {
	        return super.getDescrizione(); 
	    }
    }

}
