package graphique;

import agents.Ligne;
import jade.core.behaviours.TickerBehaviour;

public class ReDessiner extends TickerBehaviour {
	Ligne graphique;
	Dessin paint;
	public ReDessiner(Ligne _graphique, long _pos) {
		super(_graphique, _pos);
		this.graphique = _graphique;
		this.paint = _graphique.getDessin();
		
	}

	protected void onTick() {
		paint.repaint();
	}

}
