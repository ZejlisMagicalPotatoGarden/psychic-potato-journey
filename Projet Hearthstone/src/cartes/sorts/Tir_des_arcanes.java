package cartes.sorts;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Tir_des_arcanes extends Sort {

	public Tir_des_arcanes(String nom, int cout, Effet effet, String classe) {
		super("Tir des arcanes", 1, new Degats("Inflige 2 points de dégâts au personnage ciblé", "Tir des arcanes", "Immédiat", 10), "Mage");
	}

}
