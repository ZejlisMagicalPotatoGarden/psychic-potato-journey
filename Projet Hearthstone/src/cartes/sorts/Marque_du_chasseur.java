package cartes.sorts;

import cartes.effets.Degats;

public class Marque_du_chasseur extends Sort {
	/**
	 * Classe repr�sentant le sort Marque du chasseur, permet un effet de d�g�t de 1 point � la cible.
	 * Sp�cifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 * 
	 */

	public Marque_du_chasseur() {
		super("Marque du chasseur", 1, new Degats("Baisse de 1 les points de vie du serviteur cibl�", "Marque du chasseur", "Imm�diat", 0), "Mage");
	}

}
