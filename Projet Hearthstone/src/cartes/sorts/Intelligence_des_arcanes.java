package cartes.sorts;

import cartes.effets.Pioche;
import partie.partie.Partie;

public class Intelligence_des_arcanes extends Sort {
	/**
	 * Classe représentant le sort intelligence des arcanes, permet de piocher 2 cartes, c'est un effet Pioche.
	 * Spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Intelligence_des_arcanes(Partie partie) {
		super("Intelligence des arcanes", 2, new Pioche("Pioche 2 cartes","Intelligence des arcanes","Immédiat", 2, partie), "Mage");
	}

}
