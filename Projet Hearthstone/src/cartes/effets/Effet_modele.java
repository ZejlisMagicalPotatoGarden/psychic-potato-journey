package cartes.effets;

import partie.autres.personnage.Personnage;

public class Effet_modele extends Effet {
	/**
	 * Classe servant juste � tester, elle ne sera pas utilis�e dans le jeu.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 */

	public Effet_modele() {
		super("Ne fait rien parce que c'est un mod�le", "Effet mod�le", "Entr�e/Mort/Aura/Imm�diat...");
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
