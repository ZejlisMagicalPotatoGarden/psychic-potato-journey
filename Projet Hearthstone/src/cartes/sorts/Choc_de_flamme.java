package cartes.sorts;

import cartes.effets.Degats_serviteurs_adverses;
import partie.partie.Partie;

public class Choc_de_flamme extends Sort {
	/**
	 * Classe repr�sentant le sort choc de flamme, inflige un effet d�g�t de 4 points � tous les serviteurs adverses.
	 * Sp�cifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Choc_de_flamme(Partie p) {
		super("Choc de flamme", 7, new Degats_serviteurs_adverses("Inflige 4 points de d�g�ts � tous les serviteurs adverses", "Attaque massive", "Imm�diat", 4, p), "Mage");
	}

}
