package cartes.sorts;

import cartes.effets.E_Charge;

public class Charge extends Sort {

	public Charge() {
		super("Charge", 1, new E_Charge(), "Neutre");
	}

}
