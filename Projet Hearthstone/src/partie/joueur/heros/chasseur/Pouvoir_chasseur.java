package partie.joueur.heros.chasseur;

import cartes.effets.Degats_heros_adverse;
import partie.joueur.heros.pouvoir.Pouvoir;
import partie.partie.Partie;

public class Pouvoir_chasseur extends Pouvoir {
	/**
	 * Classe représentant le pouvoir spécifique au chasseur, fait 2 points de dégâts au héros adverse.
	 * 
	 * @author GRESSET Nathan
	 * @author GRIWALD Louis
	 * 
	 * @see Pouvoir
	 */

	public Pouvoir_chasseur(Partie p) {
		super(new Degats_heros_adverse("Fait 2 points de dégats au héros adverse", "Tir précis", "Immédiat", 2, p), 2);
	}

}
