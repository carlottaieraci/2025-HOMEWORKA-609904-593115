package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private IO io;
	private String parametro;

    // Costruttore che riceve IO
    public ComandoGuarda(IO io) {
        this.io = io;
    }
    
    @Override
    public String getNome() {
    	return "guarda";
    }
    
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
		io.mostraMessaggio(" " + partita.getGiocatore().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;

	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}

}
