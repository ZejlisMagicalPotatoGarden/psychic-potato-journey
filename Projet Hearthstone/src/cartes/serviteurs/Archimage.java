package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Provocation;

public class Archimage extends Serviteur {

	public Archimage(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Archimage", 6, "Neutre", 7, 4, new Provocation());
	}

}
