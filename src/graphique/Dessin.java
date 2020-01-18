package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import agents.Produit;

public class Dessin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 160; //largeur de bloc
	private static int hauteur = 60; //hauteur de bloc
	private static int distance = 160; //la distance entre 2 bloc
	private static int centre = 60;
	
	private static int pos_initial = 30; //pour etre mis en forme

	private List<Produit> lesProduits;

	public Dessin(Map<String, Map<String, Map<String, Object>>> _data) {
		super();
		this.lesProduits = new ArrayList<Produit>();
	}
	
	public List<Produit> getListProduit(){
		return lesProduits;
	}


	public void paint(Graphics g){
		
		//Dessiné 1ère bloc: Entree
		g.setColor(Color.WHITE);
		g.fillRect(pos_initial, pos_initial, largeur, hauteur);
		g.setColor(Color.BLACK);
		g.drawRect(pos_initial, pos_initial, largeur, hauteur);
		g.drawString("Entrée", (pos_initial+largeur)/2, centre);
		g.drawLine(pos_initial+largeur, centre, pos_initial+largeur+distance, centre);
		
		//Dessiné 2ème bloc: Transf
		g.setColor(Color.WHITE);
		g.fillRect(pos_initial+largeur+distance, pos_initial, largeur, hauteur);
		g.setColor(Color.BLACK);
		g.drawRect(pos_initial+largeur+distance, pos_initial, largeur, hauteur);
		g.drawString("Transf", (pos_initial+largeur+distance)+60, pos_initial+hauteur/2);
		g.drawLine(pos_initial+largeur*2+distance, centre, pos_initial+(largeur+distance)*2, centre);
		
		//Dessiné 3ème bloc: Sortie
		g.setColor(Color.WHITE);
		g.fillRect(pos_initial+(largeur+distance)*2, pos_initial, largeur, hauteur);
		g.setColor(Color.BLACK);
		g.drawRect(pos_initial+(largeur+distance)*2, pos_initial, largeur, hauteur);
		g.drawString("Sortie", (pos_initial+(largeur+distance)*2)+60, pos_initial+hauteur/2);
		
		//Dessiné les produits
		for(Produit unProduit : lesProduits) {
			g.setColor(Color.PINK);
			g.fillRect(unProduit.getPosition(), 50, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRect(unProduit.getPosition(), 50, 15, 15);
		}
	}
	

}

