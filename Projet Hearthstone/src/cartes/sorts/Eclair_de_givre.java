package cartes.sorts;

import cartes.effets.Degats_cible;

public class Eclair_de_givre extends Sort {
	/**
	 * Classe représentant le sort éclair de givre, inflige un effet de dégâts de 3 points au personnage adverse
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Carte
	 * @see Effet
	 * @see Sort
	 */

	public Eclair_de_givre() {
		super("Eclair de givre", 2, new Degats_cible("Inflige 3 points de dégâts au personnage ciblé", "Attaque du givre", "Immédiat", 3), "Mage");
	}

}
