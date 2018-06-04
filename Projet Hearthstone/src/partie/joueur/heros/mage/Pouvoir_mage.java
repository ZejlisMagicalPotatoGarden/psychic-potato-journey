package partie.joueur.heros.mage;

import cartes.effets.Degats_cible;
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
		super(new Degats_cible("Fait un point de dégat à un personnage", "Ping", "Immédiat", 1),2);
	}

}
