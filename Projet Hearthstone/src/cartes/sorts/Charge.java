package cartes.sorts;

import cartes.effets.E_Charge;

public class Charge extends Sort {
	/**
	 * Classe repr�sentant le sort charge, poss�de un effet charge.
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
