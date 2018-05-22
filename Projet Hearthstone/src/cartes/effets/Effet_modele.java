package cartes.effets;

import partie.autres.personnage.Personnage;

public class Effet_modele extends Effet {

	public Effet_modele() {
		super("Ne fait rien parce que c'est un modèle", "Effet modèle", "Entrée/Mort/Aura/Immédiat...");
	}

	@Override
	public void activer(Personnage p) {
		//Fait un truc normalement
	}
	@Override
	public boolean isActivable() {
		return false;
	}
	@Override
	public boolean isCiblable() {
		return false;
	}

}
