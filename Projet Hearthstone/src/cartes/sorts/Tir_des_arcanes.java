package cartes.sorts;

import cartes.effets.Degats;

public class Tir_des_arcanes extends Sort {

	public Tir_des_arcanes() {
		super("Tir des arcanes", 1, new Degats("Inflige 2 points de d�g�ts au personnage cibl�", "Tir des arcanes", "Imm�diat", 10), "Mage");
	}

}
