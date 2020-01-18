package agents;
import behaviours.EnvoieMessage;
import jade.core.Agent;

public class Entree extends Agent{
	private String type;
	private int quantite;
	
	public Entree(String _type, int _quantite) {
		this.type = _type;
		this.quantite = _quantite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int _quantite) {
		this.quantite = _quantite;
	}
	
	@Override
	public String toString(){
		return "Entrée: Type de produit: "+this.type+",  avec une quantité de: "+this.quantite;
	}
	
	public void setup() {

		System.out.println(getName());//getLocalName()
		
		// extraire les informations de l'agent
		Object[] args = getArguments();
		type = (String)args[0];
		quantite = (Integer)args[1];
		//System.out.println("Entrée: Type de produit: "+this.type+",  avec une quantité de: "+this.quantite);

	}
}
