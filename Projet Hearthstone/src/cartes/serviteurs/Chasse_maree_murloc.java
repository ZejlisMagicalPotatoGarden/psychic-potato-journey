package cartes.serviteurs;

import cartes.effets.Invocation;

public class Chasse_maree_murloc extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur Chasse mar�e murloc permettant d'invoquer un serviteur +1/+1.
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

	public Chasse_maree_murloc() {
		super("Chasse mar�e murloc", 2, "Neutre", 1, 2, new Invocation("Invocation d'un serviteur 1/1", "Invocation d'un eclaireur murloc", "entr�e", new Serviteur("Eclaireur murloc", 0, "neutre", 1,1, null), 1));
	}

}
