package cartes.sorts;

import cartes.effets.Degats;

public class Eclair_de_givre extends Sort {

	public Eclair_de_givre() {
		super("Eclair de givre", 2, new Degats("Inflige 3 points de d�g�ts au personnage cibl�", "Attaque du givre", "Imm�diat", 3), "Mage");
	}

}
