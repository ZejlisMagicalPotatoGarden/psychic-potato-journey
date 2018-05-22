package cartes.serviteurs;

import cartes.effets.E_Charge;

public class La_missiliere_temeraire extends Serviteur {
	/**
	 * Classe représentant le serviteur missiliaire téméraire, permet un effet de charge.
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

	public La_missiliere_temeraire() {
		super("La missilière téméraire", 6, "Neutre", 2, 5, new E_Charge());
	}

}
