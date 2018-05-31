package cartes.sorts;

import cartes.effets.Degats_heros_adverse;
import partie.partie.Partie;

public class Attaque_mentale extends Sort {
	/**
	 * Classe représentant le sort Attaque mentale, inflige 5 points de dégâts.
	 * Possède une effet de dégâts au héros adverse.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Attaque_mentale(Partie p) {
		super("Attaque mentale", 2, new Degats_heros_adverse("Inflige 5 points de dégâts au héros adverse", "Attaque mentale", "Immédiat", 5, p), "Neutre");
	}

}
