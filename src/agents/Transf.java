package agents;

import behaviours.AjouterProduit;
import behaviours.EnvoieMessage;
import behaviours.MessageChangementPosition;
import jade.core.Agent;

public class Transf extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int capacite;

	
	public void setup() {

		System.out.println("------------------------");
		System.out.println("-------Agent Transf------");
		
		System.out.println("Nom de l'agent: " + getName());
		
		// extraire les informations de l'agent
		Object[] args = getArguments();
		id = (Integer)args[0];
		capacite = (Integer)args[1];
		System.out.println("Agent de transf: " + id + " est lance");
		
		// effectuer des Behaviour de l'agent
		addBehaviour(new EnvoieMessage());// envoie une message pour changer la position ou détruire les produits
		
	}
}
