package cartes.sorts;

import cartes.effets.Degats_serviteurs_adverses;
import partie.partie.Partie;

public class Choc_de_flamme extends Sort {
	/**
	 * Classe représentant le sort choc de flamme, inflige un effet dégât de 4 points à tous les serviteurs adverses.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Choc_de_flamme(Partie p) {
		super("Choc de flamme", 7, new Degats_serviteurs_adverses("Inflige 4 points de dégâts à tous les serviteurs adverses", "Attaque massive", "Immédiat", 4, p), "Mage");
	}

}
