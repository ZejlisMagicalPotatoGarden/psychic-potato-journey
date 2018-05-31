package cartes.sorts;

import cartes.effets.Degats_cible;

public class Explosion_pyrotechnique extends Sort {
	/**
	 * Classe représentant le sort Explosion pyrotechnique, inflige un effet de dégâts de 10 points au personnage adverse.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Explosion_pyrotechnique() {
		super("Explosion pyrotechnique", 10, new Degats_cible("Inflige 10 points de dégâts au personnage ciblé", "Explosion pyrotechnique", "Immédiat", 10), "Mage");
	}

}
