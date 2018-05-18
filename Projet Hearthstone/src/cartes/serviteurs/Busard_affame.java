package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Pioche;

public class Busard_affame extends Serviteur {

	public Busard_affame(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Busard affamé", 5, "Mage", 3, new Pioche());
	}
	

}
