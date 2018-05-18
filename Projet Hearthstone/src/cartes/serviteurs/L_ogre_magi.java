package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Provocation;

public class L_ogre_magi extends Serviteur {

	public L_ogre_magi(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("L'ogre magi", 4, "Neutre", 4, 4, new Provocation());
	}

}
