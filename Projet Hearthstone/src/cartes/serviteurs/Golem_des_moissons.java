package cartes.serviteurs;

import cartes.effets.Invocation;

public class Golem_des_moissons extends Serviteur {
	/**
	 * Classe représentant le Golem des moissons, permet d'invoquer un golem endommagé +2/+1 sans capacité
	 * C'est un effet d'invocation.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see serviteurs
	 * @see effets
	 * @see carte
	 * 
	 * @param nom
	 * @param cout
	 * @param classe
	 * @param vieMax
	 * @param attaque
	 * @param effet
	 */

	public Golem_des_moissons() {
		super("Golem des moissons", 3, "Neutre", 3, 2, new Invocation("Invoque un Golem endomagé 2/1", "Golémisation", "Mort", new Serviteur("Golem endomagé", 0, "Neutre", 1, 2, null), 1));
	}

}
