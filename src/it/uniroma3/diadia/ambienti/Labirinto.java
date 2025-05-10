package uniroma3.diadia.ambienti;



import uniroma3.diadia.attrezzi.Attrezzo;


public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave",2);
		Attrezzo cibo = new Attrezzo("cibo",10);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaBloccata aulaN9 = new StanzaBloccata("Aula N9","ovest","chiave");
		StanzaBuia bagno = new StanzaBuia("Bagno","est","lanterna");
		StanzaMagica mensa = new StanzaMagica("Mensa", 0);
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", mensa);
		mensa.impostaStanzaAdiacente("nord", aulaN10);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("nord", aulaN9);
		aulaN9.impostaStanzaAdiacente("sud", laboratorio);
		aulaN9.impostaStanzaAdiacente("ovest", bagno);
		bagno.impostaStanzaAdiacente("est", aulaN9);
		bagno.impostaStanzaAdiacente("ovest", biblioteca);
		biblioteca.impostaStanzaAdiacente("est", bagno);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(chiave);
		mensa.addAttrezzo(cibo);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
	
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public String toString() {
		return getStanzaCorrente().toString();
	}
}
