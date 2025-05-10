package uniroma3.diadia.comandi;

import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private IO io;
	private String parametro;

    // Costruttore che riceve IO
    public ComandoNonValido(IO io) {
        this.io = io;
    }
    
    @Override
    public String getNome() {
    	return "nonvalido";
    }

	@Override
	public void esegui(Partita partita) {
		 io.mostraMessaggio("Comando non valido.");

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
