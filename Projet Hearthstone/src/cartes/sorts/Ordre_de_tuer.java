package cartes.sorts;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Ordre_de_tuer extends Sort {

	public Ordre_de_tuer(String nom, int cout, Effet effet, String classe) {
		super("Ordre de tuer", 3, new Degats("Inflige 3 points de d�g�ts au personnage cibl�", "Ordre de tuer", "Imm�diat", 3), "Mage");
	}

}
