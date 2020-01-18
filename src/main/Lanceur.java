package main;
import jade.core.Runtime;

import java.util.List;
import java.util.Map;
import java.util.Random;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Lanceur {
	
	private static final Random rand = new Random();
	public static int nbProduits = 6; // saissir un pair nombre
	
	
	public static void main(String[] args) throws StaleProxyException {

		//Lire le contenu des fichiers pour récupérer l'information
		Map<String, Map<String, Map<String, Object>>> data = LireFichier.chargement("data.txt");
		
		Runtime rt = Runtime.instance();
		rt.setCloseVM(true);
		Profile pMain  = new ProfileImpl("localhost", 8888,null);
		AgentContainer mc = rt.createMainContainer(pMain);
		
		//Démarrer l'agent des produits
		AgentController ac = mc.createNewAgent("ligne", "agents.Ligne", 
				new Object[] {nbProduits,data});
		
		
		//Démarrer l'agent de sender
		
		AgentController sp = mc.createNewAgent("sp2", "agents.Transf", 
				new Object[] {2, 5});
		sp.start();
		ac.start();
	
		
	}
	
}
