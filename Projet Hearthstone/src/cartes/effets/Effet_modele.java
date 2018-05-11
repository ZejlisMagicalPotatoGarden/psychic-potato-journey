package cartes.effets;

import partie.autres.cible.Cible;

public class Effet_modele extends Effet {

	public Effet_modele() {
		super("Ne fait rien parce que c'est un mod�le", "Effet mod�le", "Entr�e/Mort/Aura/Imm�diat...");
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
