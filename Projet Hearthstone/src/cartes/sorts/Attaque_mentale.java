package cartes.sorts;

import cartes.effets.Degats;

public class Attaque_mentale extends Sort {

	public Attaque_mentale() {
		super("Attaque mentale", 2, new Degats("Inflige 5 points de dégâts au héros adverse", "Attaque mentale", "Immédiat", 5), "Neutre");
	}

}
