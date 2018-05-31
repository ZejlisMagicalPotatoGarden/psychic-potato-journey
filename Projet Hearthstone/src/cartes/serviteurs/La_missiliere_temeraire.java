package cartes.serviteurs;

import cartes.effets.E_Charge;

public class La_missiliere_temeraire extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur missiliaire t�m�raire, permet un effet de charge.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * 
	 */

	public La_missiliere_temeraire() {
		super("La missili�re t�m�raire", 6, "Neutre", 2, 5, new E_Charge());
	}

}
