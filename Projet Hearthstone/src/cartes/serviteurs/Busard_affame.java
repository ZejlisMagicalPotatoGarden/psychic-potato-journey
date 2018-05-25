package cartes.serviteurs;

import cartes.effets.Pioche;
import partie.partie.Partie;

public class Busard_affame extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur Busard affam�, il permet de piocher une carte.
	 * Sp�cifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * @see Effet
	 * @see Carte
	 */

	public Busard_affame(Partie partie) {
		super("Busard affam�", 5, "Chasseur", 3, 2, new Pioche("Pioche une carte","Pioche","Entr�e",1, partie));
	}
	

}
