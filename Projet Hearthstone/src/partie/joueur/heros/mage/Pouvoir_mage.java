package partie.joueur.heros.mage;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_mage extends Pouvoir {
	/**
	 * Classe représentant le pouvoir du mage, inflige un point de dégât à un personnage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Mage
	 * @see Pouvoir
	 */

	public Pouvoir_mage() {
		super(new Degats("Fait un point de dégat à un personnage", "Ping", "Immédiat", 1),2);
	}

}
