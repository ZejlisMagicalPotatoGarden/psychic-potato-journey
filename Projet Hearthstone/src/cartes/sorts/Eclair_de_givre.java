package cartes.sorts;

import cartes.effets.Degats;

public class Eclair_de_givre extends Sort {
	/**
	 * Classe repr�sentant le sort �clair de givre, inflige un effet de d�g�ts de 3 points au personnage adverse
	 * Sp�cifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Eclair_de_givre() {
		super("Eclair de givre", 2, new Degats("Inflige 3 points de d�g�ts au personnage cibl�", "Attaque du givre", "Imm�diat", 3), "Mage");
	}

}
