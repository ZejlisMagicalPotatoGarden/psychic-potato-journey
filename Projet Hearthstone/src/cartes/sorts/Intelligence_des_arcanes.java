package cartes.sorts;

import cartes.effets.Pioche;
import cartes.serviteurs.Serviteur;

public class Intelligence_des_arcanes extends Sort {
	/**
	 * Classe représentant le sort intelligence des arcanes, permet de piocher 2 cartes, c'est un effet Pioche.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Carte
	 * @see Effet
	 * @see Serviteur
	 * @see Sort
	 */

	public Intelligence_des_arcanes() {
		super("Intelligence des arcanes", 2, new Pioche("Pioche 2 cartes","Intelligence des arcanes","Immédiat", 2), "Mage");
	}

}
