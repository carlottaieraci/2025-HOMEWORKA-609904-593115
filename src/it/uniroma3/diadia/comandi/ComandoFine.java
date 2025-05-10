package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO io;
	private String parametro;

    // Costruttore che riceve IO
    public ComandoFine(IO io) {
        this.io = io;
    }
    
    @Override
    public String getNome() {
    	return "fine";
    }

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie per aver giocato!");

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
