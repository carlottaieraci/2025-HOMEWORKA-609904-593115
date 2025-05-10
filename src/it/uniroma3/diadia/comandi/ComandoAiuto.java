package uniroma3.diadia.comandi;

import uniroma3.diadia.DiaDia;
import uniroma3.diadia.IO;
import uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	private IO io;
	private String parametro;

    // Costruttore che riceve IO
    public ComandoAiuto(IO io) {
        this.io = io;
    }
    
    @Override
    public String getNome() {
    	return "aiuto";
    }

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comandi disponibili: vai, aiuto, fine, prendi, posa, guarda");;
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
