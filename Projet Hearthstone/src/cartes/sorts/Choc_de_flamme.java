package cartes.sorts;

import cartes.effets.Degats;

public class Choc_de_flamme extends Sort {
	/**
	 * Classe représentant le sort choc de flamme, inflige un effet dégât de 4 points à tous les serviteurs adverses.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Carte
	 * @see Effet
	 * @see Sort
	 */

	public Choc_de_flamme() {
		super("Choc de flamme", 7, new Degats("Inflige 4 points de dégâts à tous les serviteurs adverses", "Attaque massive", "Immédiat", 4), "Mage");
	}

}
