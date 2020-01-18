package agents;

import jade.core.Agent;
public class Produit extends Agent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int num = 0;
	private int ID;
	private int type;
	private boolean etat;
	private int position; //postion dans la chaine de production
	
	public Produit(int _type, boolean _etat, int _position) {
		this.ID = num;
		num++;
		this.type = _type;
		this.etat = _etat;
		this.position = _position;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int _id) {
		ID = _id;
	}
	
	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean _etat) {
		this.etat = _etat;
	}

	public int getType() {
		return type;
	}
	public void setType(int _type) {
		this.type = _type;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int _position) {
		this.position = _position;
	}
	
}
