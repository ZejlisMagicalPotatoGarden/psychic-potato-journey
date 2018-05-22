package cartes.sorts;

import cartes.effets.Degats;

public class Tir_des_arcanes extends Sort {
	/**
	 * Classe représentant le sort tir des arcanes, permet un effet de dégâts de 2 points au personnage ciblé.
	 * Spécifique au chasseur
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 * @see sorts
	 * @see carte
	 * 
	 * @param nom
	 * @param cout
	 * @param effet
	 * @param classe
	 */

	public Tir_des_arcanes() {
		super("Tir des arcanes", 1, new Degats("Inflige 2 points de dégâts au personnage ciblé", "Tir des arcanes", "Immédiat", 10), "Mage");
	}

}
