package cartes.sorts;

import cartes.effets.Degats;

public class Explosion_pyrotechnique extends Sort {
	/**
	 * Classe repr�sentant le sort Explosion pyrotechnique, inflige un effet de d�g�ts de 10 points au personnage adverse.
	 * Sp�cifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Explosion_pyrotechnique() {
		super("Explosion pyrotechnique", 10, new Degats("Inflige 10 points de d�g�ts au personnage cibl�", "Explosion pyrotechnique", "Imm�diat", 10), "Mage");
	}

}
