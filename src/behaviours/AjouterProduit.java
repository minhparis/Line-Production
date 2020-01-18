package behaviours;

import java.util.List;

import agents.Ligne;
import agents.Produit;
import graphique.Dessin;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AjouterProduit extends Behaviour {
	
	int id = 0;

	public void action() {
		id++;
		Dessin paint = ((Ligne)myAgent).getDessin();
		List<Produit> lesProduits = paint.getListProduit();
		Produit unProduit = new Produit(0, true, id*30);
		lesProduits.add(unProduit);
		System.out.println("Produit "+unProduit.getID() + " est ajouté");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean done() {
		if(id>=((Ligne)myAgent).getCapacite()) {
			return true;
		}
		return false;	
		
	}

}
