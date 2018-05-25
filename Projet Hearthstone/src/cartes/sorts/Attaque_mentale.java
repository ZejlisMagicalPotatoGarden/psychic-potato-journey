package cartes.sorts;

import cartes.effets.Degats;

public class Attaque_mentale extends Sort {
	/**
	 * Classe repr�sentant le sort Attaque mentale, inflige 5 points de d�g�ts.
	 * Poss�de une effet de d�g�ts.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Carte
	 * @see Sort
	 * @see Effet
	 */

	public Attaque_mentale() {
		super("Attaque mentale", 2, new Degats("Inflige 5 points de d�g�ts au h�ros adverse", "Attaque mentale", "Imm�diat", 5), "Neutre");
	}

}
