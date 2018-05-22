package cartes.sorts;

import cartes.effets.Degats;

public class Ordre_de_tuer extends Sort {

	public Ordre_de_tuer() {
		super("Ordre de tuer", 3, new Degats("Inflige 3 points de dégâts au personnage ciblé", "Ordre de tuer", "Immédiat", 3), "Mage");
	}

}
