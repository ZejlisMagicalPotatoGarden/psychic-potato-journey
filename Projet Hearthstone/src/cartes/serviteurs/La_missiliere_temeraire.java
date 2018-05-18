package cartes.serviteurs;

import cartes.effets.E_Charge;
import cartes.effets.Effet;

public class La_missiliere_temeraire extends Serviteur {

	public La_missiliere_temeraire(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("La missilière téméraire", 6, "Neutre", 2, 5, new E_Charge());
	}

}
