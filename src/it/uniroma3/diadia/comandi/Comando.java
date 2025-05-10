package uniroma3.diadia.comandi;

import uniroma3.diadia.ambienti.Stanza;

import java.util.Scanner;

import uniroma3.diadia.Partita;
import uniroma3.diadia.ambienti.Labirinto;

public interface Comando {
	
	
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	
	public String getNome();
	public String getParametro();
	
}
