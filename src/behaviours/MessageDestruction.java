package behaviours;

import java.util.List;

import agents.Ligne;
import agents.Produit;
import graphique.Dessin;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class MessageDestruction extends CyclicBehaviour {
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage m = myAgent.receive(MessageTemplate.MatchPerformative(EnvoieMessage.perf_destruction));
		
		if(m == null) {
			block();
		}else {// s'il existe une message pour le déstruction du produit
			int idProduit = Integer.parseInt(m.getContent());
			
			//re-dessiner l'interface
			Dessin paint = ((Ligne)myAgent).getDessin();//récuper le dessin actuel
			//chercher le produit qui est informé à detruire
			List<Produit> lesProduits = paint.getListProduit();
			for(Produit unProduit:lesProduits) {
				if(unProduit.getID() == idProduit){
					lesProduits.remove(unProduit);//et le detruire
					break;
				}
			}
			System.out.println("Le produit " + idProduit+ " est detruit");
		}
	}

}
