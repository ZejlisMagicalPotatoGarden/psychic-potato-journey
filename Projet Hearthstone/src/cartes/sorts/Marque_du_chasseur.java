package cartes.sorts;

import cartes.effets.Degats;

public class Marque_du_chasseur extends Sort {

	public Marque_du_chasseur() {
		super("Marque du chasseur", 1, new Degats("Abaisse � 1 les points de vie du serviteur cibl�", "Marque du chasseur", "Imm�diat", 0), "Mage");
	}

}
