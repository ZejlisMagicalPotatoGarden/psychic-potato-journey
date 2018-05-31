package cartes.sorts;

import cartes.effets.Degats_cible;

public class Tir_des_arcanes extends Sort {
	/**
	 * Classe repr�sentant le sort tir des arcanes, permet un effet de d�g�ts de 2 points au personnage cibl�.
	 * Sp�cifique au chasseur
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 * @see Carte
	 * 
	 */

	public Tir_des_arcanes() {
		super("Tir des arcanes", 1, new Degats_cible("Inflige 2 points de d�g�ts au personnage cibl�", "Tir des arcanes", "Imm�diat", 2), "Chasseur");
	}

}
