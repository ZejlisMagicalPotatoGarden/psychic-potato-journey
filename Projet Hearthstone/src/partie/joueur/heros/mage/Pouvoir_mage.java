package partie.joueur.heros.mage;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_mage extends Pouvoir {

	public Pouvoir_mage() {
		super(new Degats("Fait un point de dégat à un personnage", "Ping", "Immédiat", 1),2);
	}

}
