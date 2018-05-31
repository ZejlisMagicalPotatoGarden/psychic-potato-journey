package partie.joueur.heros.chasseur;

import cartes.effets.Degats_heros_adverse;
import partie.joueur.heros.pouvoir.Pouvoir;
import partie.partie.Partie;

public class Pouvoir_chasseur extends Pouvoir {

	public Pouvoir_chasseur(Partie p) {
		super(new Degats_heros_adverse("Fait 2 points de dégats au héros adverse", "Tir précis", "Immédiat", 2, p), 2);
	}

}
