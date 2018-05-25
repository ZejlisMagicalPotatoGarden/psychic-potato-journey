package cartes.serviteurs;

import cartes.effets.Pioche;

public class Busard_affame extends Serviteur {
	/**
	 * Classe représentant le serviteur Busard affamé, il permet de piocher une carte.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * @see Effet
	 * @see Carte
	 */

	public Busard_affame() {
		super("Busard affamé", 5, "Chasseur", 3, 2, new Pioche("Pioche une carte","Pioche","Entrée",1));
	}
	

}
