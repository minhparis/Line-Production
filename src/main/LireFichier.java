package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import agents.Entree;
import agents.Sortie;

public class LireFichier {

	public static void main(String[] args) {
		Map<String, Map<String, Map<String, Object>>> data = chargement("data.txt");
	}
	
	public static Map<String, Map<String, Map<String, Object>>> chargement(String filePath) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String ligne; //chaque ligne dans le fichier à lire
			
			//on définit 3 hashmap
			//un double-hashmap (resultat final) contenant tous les informations
			Map<String, Map<String, Map<String, Object>>> data = new HashMap<String, Map<String, Map<String, Object>>>();
			//deux hashmap pour stocker les informations de Machines et lignes
			Map<String,Map<String, Object>> lesMachines = new HashMap<String, Map<String, Object>>();
			Map<String,Map<String, Object>>  lesLignes = new HashMap<String, Map<String, Object>>();
			
			//extraire les champs de chaque ligne
			while ((ligne=br.readLine())!=null) {
				System.out.println("lu: " + ligne);
				
				String [] t = ligne.split(":",2);
				//----------------------
				//Traitement de Machines
				//----------------------
				if(t[0] == "transf"){
					//extraire les informations
					Matcher df = Pattern.compile("(\\w*);\\[(.*)];\\[(.*)];(\\d*);([\\d.]*);\\((\\d*),(\\d*)\\)").matcher(t[1]);//expression reguliere en java
	
					Map<String,Object> uneMachine = new HashMap<String, Object>();

					// -duree de traitement
					uneMachine.put("tempsExecution", Integer.parseInt(df.group(4)));
					
					// -probabilite d'erreur
					uneMachine.put("probErreur", Double.parseDouble(df.group(4)));
					
					// Traitement de la liste des entrees
					List<Entree> listeEntree = new ArrayList<Entree>(); //initialiser la liste des entrees
					for(String element:df.group(2).split(",")) { //parcourir tous les elements pour recuperer les entrees
						String[] elementExtraite = element.split(":",2); //les informations pour l'entree est dans 2eme position
						Entree uneEntree = new Entree(elementExtraite[0], Integer.parseInt(elementExtraite[1])); // (type de produit, quantite de produit)
						listeEntree.add(uneEntree);
					}
					// -liste des entrées
					uneMachine.put("listeEntree", listeEntree);
					
					// Traitement de la liste des sorties
					List<Sortie> listeSortie = new ArrayList<Sortie>(); //initialiser la liste des sorties
					for(String element:df.group(2).split(",")) { //parcourir tous les elements pour recuperer les sorites
						String[] elementExtraite = element.split(":",3);
						Sortie uneSortie = new Sortie(elementExtraite[0], elementExtraite[1], Integer.parseInt(elementExtraite[2])); // (type de produit, quantite de produit)
						listeSortie.add(uneSortie);
					}
					// -liste des sorties
					uneMachine.put("listeSortie", listeSortie);
							
					//- position dans l'interface de visualisation
					uneMachine.put("x", Integer.parseInt(df.group(6))); //coordonnee de l'axe horizontal
					uneMachine.put("y", Integer.parseInt(df.group(7))); //coordonnee de l'axe verticale
	
					lesMachines.put(df.group(1), uneMachine); //nom de la machine avec les elements de Machine ci-dessous
					
					//--------------------
					//Traitement de Lignes
					//--------------------
				}else { //t[0] == 'ligne'
					String [] df = t[1].split(";");

					//pour chaque Machine Ligne
					Map<String,Object> uneLigne = new HashMap<String, Object>();
					uneLigne.put("machineSource", df[1]); //machine source
					uneLigne.put("machineCible", df[2]); //machine cible
					uneLigne.put("capacite", Integer.parseInt(df[3]));//capacite
					
					//on ajoute tout dans un hashmap
					lesLignes.put(df[0], uneLigne); //un nom de chaque machine
					
				}
			}
			
			//ajoute les 2 hashmap dans un résultat final
			data.put("Machines", lesMachines);
			data.put("Lignes", lesLignes);
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("fichier pas trouve");
		} catch (IOException e) {
			System.err.println("erreur lors de la lecture du fichier");
		}
		return null;
	}
	

}

