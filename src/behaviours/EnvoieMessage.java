package behaviours;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import main.Lanceur;

public class EnvoieMessage extends Behaviour {
	public static int perf_changement = 2; //performatif du message pour le changement de position
	public static int perf_destruction = 3; //performatif du message pour détruire des produits
	private int idProduit = 1;
	private int nbProduits = Lanceur.nbProduits;
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage m;
	
		if(idProduit>0 && idProduit<=nbProduits/2) {//envoyer une message de changement de position
			m = new ACLMessage(perf_changement);
			m.setContent(idProduit + "");//id du produit est 
			m.addReceiver(new AID("ligne",false));//destinataire est l'agent ligne
			myAgent.send(m);
			idProduit++;
			try {//le temps delay entre chaque fois de déplacement
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(idProduit>nbProduits/2 && idProduit<=nbProduits){//envoyer une message de destruction de produit
			m = new ACLMessage(perf_destruction);
			m.setContent((idProduit-nbProduits*2/3) + ""); //détruit 1/3 des produits
			m.addReceiver(new AID("ligne",false));
			myAgent.send(m);
			idProduit++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			idProduit++;
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
