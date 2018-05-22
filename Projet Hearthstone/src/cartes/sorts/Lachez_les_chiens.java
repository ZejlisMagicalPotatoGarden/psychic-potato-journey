package cartes.sorts;

import cartes.effets.Effet;

public class Lachez_les_chiens extends Sort {
	/**
	 * Classe représentant le sort lachez les chiens, permet un effet d'invocation de deux chiens 1/1.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 * @see carte
	 * @see sorts
	 * @see serviteurs
	 * 
	 * @param nom
	 * @param cout
	 * @param effet
	 * @param classe
	 */

	public Lachez_les_chiens(String nom, int cout, Effet effet, String classe) {
		super("Lachez_les_chiens", 3, new Invocation(), "Mage");
	}

}
