package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Pioche;

public class Busard_affame extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur Busard affam�, il permet de piocher une carte.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see serviteurs
	 * @see effets
	 */

	public Busard_affame(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Busard affam�", 5, "Mage", 3, new Pioche());
	}
	

}
