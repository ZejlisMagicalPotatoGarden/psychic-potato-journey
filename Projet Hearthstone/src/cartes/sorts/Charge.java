package cartes.sorts;

import cartes.effets.E_Charge;

public class Charge extends Sort {
	/**
	 * Classe représentant le sort charge, donne un effet charge à un serviteur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */

	public Charge() {
		super("Charge", 1, new E_Charge(), "Neutre");
	}

}
