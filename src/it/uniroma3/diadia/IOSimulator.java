package uniroma3.diadia;

public class IOSimulator implements IO {
	
	private String[] daLeggere;
	private String[] daStampare;
	private int itLettura;
	private int itScrittura;
	
	public IOSimulator(String[] comandi) {
		this.daLeggere = comandi;
		this.daStampare = new String[500];
		this.itLettura = 0;
		this.itScrittura= 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		if(itScrittura < daStampare.length)
			this.daStampare[itScrittura++] =  messaggio;
	}

	@Override
	public String leggiRiga() {

		if(itLettura < daLeggere.length) {
			return this.daLeggere[itLettura++];
		}
		return null;
	}
	
	public String[] getDaStampare() {
		return this.daStampare;
	}

}
