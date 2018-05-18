package cartes.sorts;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Marque_du_chasseur extends Sort {

	public Marque_du_chasseur(String nom, int cout, Effet effet, String classe) {
		super("Marque du chasseur", 1, new Degats("Abaisse à 1 les points de vie du serviteur ciblé", "Marque du chasseur", "Immédiat", 2), "Mage");
	}

}
