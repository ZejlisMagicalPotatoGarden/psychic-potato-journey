package cartes.sorts;

import cartes.effets.Degats_vie_a_x;

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
		super("Marque du chasseur", 1, new Degats_vie_a_x("Abaisse à 1 les points de vie du serviteur ciblé", "Marque du chasseur", "Immédiat", 1), "Chasseur");
	}
}
