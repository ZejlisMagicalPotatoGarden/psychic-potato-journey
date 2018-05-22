package cartes.sorts;

import cartes.effets.Effet;
import cartes.effets.Pioche;

public class Intelligence_des_arcanes extends Sort {
	/**
	 * Classe représentant le sort intelligence des arcanes, permet de piocher 2 cartes, c'est un effet Pioche.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see carte
	 * @see deck
	 * @see sorts
	 * @see effets
	 */

	public Intelligence_des_arcanes() {
		super("Intelligence des arcanes", 2, new Pioche(), classe);
	}

}
