package cartes.sorts;

import cartes.effets.Degats;

public class Eclair_de_givre extends Sort {

	public Eclair_de_givre() {
		super("Eclair de givre", 2, new Degats("Inflige 3 points de dégâts au personnage ciblé", "Attaque du givre", "Immédiat", 3), "Mage");
	}

}
