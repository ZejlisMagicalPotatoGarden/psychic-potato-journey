package cartes.sorts;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Ordre_de_tuer extends Sort {
	/**
	 * Classe représentant le sort ordre de tuer, permet un effet de dégâts infligeant 3 points de dégâts au personnage ciblé.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 * @see carte
	 * @see sorts
	 * 
	 * @param nom
	 * @param cout
	 * @param effet
	 * @param classe
	 */

	public Ordre_de_tuer(String nom, int cout, Effet effet, String classe) {
		super("Ordre de tuer", 3, new Degats("Inflige 3 points de dégâts au personnage ciblé", "Ordre de tuer", "Immédiat", 3), "Mage");
	}

}
