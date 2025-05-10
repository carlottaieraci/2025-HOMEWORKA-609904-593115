package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.giocatore.borsa;
import uniroma3.diadia.giocatore.giocatore;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	private IO io;

    // Costruttore che riceve IO
    public ComandoPosa(IO io) {
        this.io = io;
    }

    @Override
    public String getNome() {
    	return "posa";
    }
	
	@Override
	public void esegui(Partita partita) {
		
		giocatore giocatore = partita.getGiocatore();
		
		if (!giocatore.getBorsa().hasAttrezzo(nomeAttrezzo)) {
	        io.mostraMessaggio("Errore: Non hai questo attrezzo nella borsa.");
	        return;
	    }
		
		Attrezzo a = giocatore.getBorsa().getAttrezzo(nomeAttrezzo);
		giocatore.getBorsa().removeAttrezzo(a);
		
		if(partita.getLabirinto().getStanzaCorrente() == null) {
			 io.mostraMessaggio("Errore: La stanza non e' valida.");
		     return;
		}
		
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		io.mostraMessaggio("Hai posato l'attrezzo: " + a.getNome());
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	
}
