package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Invocation;

public class Chasse_maree_murloc extends Serviteur {

	public Chasse_maree_murloc(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Chasse marée murloc", 2, "Neutre", 1, 2, new Invocation("Invocation d'un serviteur +1/+1", "Cri de guerre", "?", new Serviteur("Chasse marree murloc", 0, "?", 1,1, null), null));
	}

}
