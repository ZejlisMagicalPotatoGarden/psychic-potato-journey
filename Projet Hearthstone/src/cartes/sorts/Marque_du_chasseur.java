package cartes.sorts;

import cartes.effets.Degats_vie_a_x;

public class Marque_du_chasseur extends Sort {
	/**
	 * Classe repr�sentant le sort Marque du chasseur, met la vie d'une cible � 1
	 * Sp�cifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 * 
	 */

	public Marque_du_chasseur() {
		super("Marque du chasseur", 1, new Degats_vie_a_x("Abaisse � 1 les points de vie du serviteur cibl�", "Marque du chasseur", "Imm�diat", 1), "Chasseur");
	}
}
