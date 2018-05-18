package partie.joueur.heros.chasseur;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_chasseur extends Pouvoir {

	public Pouvoir_chasseur() {
		super(new Degats("Fait 2 points de dégats au héros adverse", "Tir précis", "Immédiat", 2), 2);
	}

}
