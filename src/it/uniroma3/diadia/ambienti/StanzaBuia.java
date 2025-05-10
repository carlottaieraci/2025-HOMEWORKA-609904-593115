package uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza {
	
	private String nomeAttrezzo;
	private String direzionePrima;


	public StanzaBuia(String nome,String direzionePrima, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
		this.direzionePrima = direzionePrima;
	}
	
	@Override
	public String getDescrizione() {
		
		if(this.hasAttrezzo(this.nomeAttrezzo)) {
			return super.getDescrizione();
		}
		else {
			return "qui c'è buio pesto, devi posare l'attrezzo: " + this.nomeAttrezzo + ".Se non ce l'hai,sei venuto da: " + this.direzionePrima + ". Torna indietro!";
		}
        
    }
}
