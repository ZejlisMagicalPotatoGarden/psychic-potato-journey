package partie.joueur.heros.chasseur;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_chasseur extends Pouvoir {
	/**
	 * Classe représentant le pouvoir spécifique au chasseur, fait 2 points de dégâts au héros adverse.
	 * 
	 * @author GRESSET Nathan
	 * @author GRIWALD Louis
	 * 
	 * @see Pouvoir
	 */

	public Pouvoir_chasseur() {
		super(new Degats("Fait 2 points de dégats au héros adverse", "Tir précis", "Immédiat", 2), 2);
	}

}
