package cartes.sorts;

import cartes.effets.E_Charge;

public class Charge extends Sort {
	/**
	 * Classe représentant le sort charge, possède un effet charge.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see carte
	 * @see effets
	 * @see sorts
	 */

	public Charge() {
		super("Charge", 1, new E_Charge(), "Neutre");
	}

}
