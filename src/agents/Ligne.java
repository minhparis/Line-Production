package agents;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;

import behaviours.AjouterProduit;
import behaviours.MessageDestruction;
import graphique.Dessin;
import graphique.ReDessiner;
import behaviours.MessageChangementPosition;
import jade.core.Agent;
import jade.core.Runtime;

public class Ligne extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capacite;
	private int state;
	private Dessin paint; //afin de dessiner l'interface
	private long dureeTransf;
	
	public int getCapacite() {
		return capacite;
	}
	public int getState() {
		return state;
	}
	public Dessin getDessin() {
		return paint;
	}
	
	public void setup() {
		long st = System.currentTimeMillis();//enregistrer le moment de début
		
		System.out.println("------------------------");
		System.out.println("-------Agent Ligne------");
		
		System.out.println(getName());//getLocalName()
		Object[] args = getArguments();
		capacite = (Integer)args[0];
		Map<String, Map<String, Map<String, Object>>> data = (Map<String, Map<String, Map<String, Object>>>) args[1];
		//System.out.println("Lancer Interface: " + capacite);
		
		//dessiner l'interface
		JFrame fenetre = new JFrame("Chaine de production"); //fenetre d'interface
		paint = new Dessin(data);
		paint.setPreferredSize(new Dimension(1000,400));
		fenetre.add(paint);
		fenetre.pack();
		fenetre.setVisible(true);
		
		//effectuer les Behaviours de l'agent
		System.out.println("------------------------");
		System.out.println("--Ajouter des produits--");
		System.out.println("------------------------");
		addBehaviour(new AjouterProduit()); //l'agent ajoute des produits
		addBehaviour(new ReDessiner(this, 100)); //acher l'état du système apres un instant
		addBehaviour(new MessageChangementPosition()); //l'agent vérifie let messages de changement de postion et effectue le changement si besoin
		addBehaviour(new MessageDestruction());// il recevoit les messages de supprimation
		//calculer le temps d'execution
		dureeTransf = System.currentTimeMillis() - st;
		System.out.println("Le processus a été exécuté pendant " + dureeTransf);

	}
}
