package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Invocation;

public class Golem_des_moissons extends Serviteur {
	/**
	 * Classe repr�sentant le Golem des moissons, permet d'invoquer un golem endommag� +2/+1 sans capacit�
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

	public Golem_des_moissons(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Golem des moissons", 3, "Neutre", 3, 2, new Invocation("Invoque un Golem endomag� +2/+1 qui n'a aucune capacit�", "Gol�misation", "Mort", new Serviteur("Golem endomag�", 0, "Neutre", 1, 2, null), null));
	}

}
