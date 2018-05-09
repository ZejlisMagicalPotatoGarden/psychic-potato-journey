package partie.joueur.heros.chasseur;

import cartes.effets.Effet_chasseur;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_chasseur extends Pouvoir {

	public Pouvoir_chasseur() {
		super(new Effet_chasseur(),2);
	}

}
