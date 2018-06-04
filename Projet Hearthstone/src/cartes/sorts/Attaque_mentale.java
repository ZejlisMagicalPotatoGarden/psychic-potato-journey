package cartes.sorts;

import cartes.effets.Degats_heros_adverse;
import partie.partie.Partie;

public class Attaque_mentale extends Sort {
	/**
	 * Classe repr�sentant le sort Attaque mentale, inflige 5 points de d�g�ts.
	 * Poss�de une effet de d�g�ts au h�ros adverse.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Attaque_mentale(Partie p) {
		super("Attaque mentale", 2, new Degats_heros_adverse("Inflige 5 points de d�g�ts au h�ros adverse", "Attaque mentale", "Imm�diat", 5, p), "Neutre");
	}

}
