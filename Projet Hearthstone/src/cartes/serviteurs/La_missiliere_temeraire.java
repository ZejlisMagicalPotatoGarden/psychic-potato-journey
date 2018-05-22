package cartes.serviteurs;

import cartes.effets.Charge;
import cartes.effets.Effet;

public class La_missiliere_temeraire extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur missiliaire t�m�raire, permet un effet de charge.
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

	public La_missiliere_temeraire(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("La missili�re t�m�raire", 6, "Neutre", 2, 5, new Charge());
	}

}
