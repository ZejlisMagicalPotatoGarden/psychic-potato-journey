package cartes.sorts;

import cartes.effets.Degats;

public class Attaque_mentale extends Sort {
	/**
	 * Classe représentant le sort Attaque mentale, inflige 5 points de dégâts.
	 * Possède une effet de dégâts.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Carte
	 * @see Sort
	 * @see Effet
	 */

	public Attaque_mentale() {
		super("Attaque mentale", 2, new Degats("Inflige 5 points de dégâts au héros adverse", "Attaque mentale", "Immédiat", 5), "Neutre");
	}

}
