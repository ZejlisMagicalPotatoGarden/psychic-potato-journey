package cartes.effets;

import partie.autres.cible.Cible;

public class Effet_modele extends Effet {
	/**
	 * Classe servant juste à tester, elle ne sera pas utilisée dans le jeu.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 */

	public Effet_modele() {
		super("Ne fait rien parce que c'est un modèle", "Effet modèle", "Entrée/Mort/Aura/Immédiat...");
	}

	@Override
	public void activer(Cible c) {
		//Fait un truc normalement
	}
	@Override
	public boolean isActivable(Cible c) {
		return false;
	}
	@Override
	public boolean isCiblable() {
		return false;
	}

}
