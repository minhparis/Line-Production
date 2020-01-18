package behaviours;

import java.util.List;

import agents.Ligne;
import agents.Produit;
import graphique.Dessin;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class MessageChangementPosition extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int distance = 550;

	@Override
	public void action() {
		// verifier les messages de changement de position
		ACLMessage m = myAgent.receive(MessageTemplate.MatchPerformative(EnvoieMessage.perf_changement));
		if(m == null) {
			block();
		}else {
			//extraire le contenu dans ces messages
			int idProduit = Integer.parseInt(m.getContent());

			//re-dessiner l'interface
			Dessin paint = ((Ligne)myAgent).getDessin();
			List<Produit> lesProduits = paint.getListProduit();
			for(Produit unProduit:lesProduits) {
				if(unProduit.getID() == idProduit) {//quand on a trouve le produit qui est demande a deplacer
					unProduit.setPosition(unProduit.getPosition()+distance); //on ajoute la distance pour le deplacer
				}
			}
		System.out.println("Produit "+ idProduit+" est deplace "+distance);
			
		}
		
	}

}
