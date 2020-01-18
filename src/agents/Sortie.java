package agents;

public class Sortie extends Entree{
	private String ligne;
	
	public Sortie(String _ligne, String _type, int _quantite) {
		super(_type,_quantite); 
		this.ligne = _ligne;
	}
	public String getLigneName() {
		return ligne;
	}
	public void setLigneName(String ligneName) {
		this.ligne = ligneName;
	}

}
