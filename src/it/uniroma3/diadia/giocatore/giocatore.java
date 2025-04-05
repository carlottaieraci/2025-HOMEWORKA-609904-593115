package uniroma3.diadia.giocatore;

public class giocatore {
	
	private static final int CFU_INIZIALI = 20;
	private int cfu;
	private borsa Borsa;
	
	public giocatore() {
		this.Borsa = new borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public int getCfu(){
		return this.cfu;
	}
	
	public borsa getBorsa() {
        return this.Borsa;
    }
	
}
