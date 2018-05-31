package cartes.sorts;

import cartes.effets.Degats;

public class Marque_du_chasseur extends Sort {
	/**
	 * Classe représentant le sort Marque du chasseur, permet un effet de dégât de 1 point à la cible.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 * 
	 */

	public Marque_du_chasseur() {
		super("Marque du chasseur", 1, new Degats("Baisse de 1 les points de vie du serviteur ciblé", "Marque du chasseur", "Immédiat", 0), "Mage");
	}

}
