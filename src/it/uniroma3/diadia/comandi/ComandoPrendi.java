package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;

import uniroma3.diadia.Partita;
import uniroma3.diadia.attrezzi.Attrezzo;
import uniroma3.diadia.giocatore.giocatore;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	private IO io;

    // Costruttore che riceve IO
    public ComandoPrendi(IO io) {
        this.io = io;
    }
	
    @Override
    public String getNome() {
    	return "prendi";
    }

	@Override
	public void esegui(Partita partita) {
		
		if(partita.getLabirinto().getStanzaCorrente() == null) {
			io.mostraMessaggio("Errore: stanza corrente non valida.");
			return;
		}

		if (!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
	        io.mostraMessaggio("Errore: attrezzo non trovato nella stanza.");
	        return;
	    }

		
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		
		if(!partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			io.mostraMessaggio("Borsa piena!");
			return;
		}
		else {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			io.mostraMessaggio("Hai preso l'attrezzo: " + a.getNome());
		}
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
