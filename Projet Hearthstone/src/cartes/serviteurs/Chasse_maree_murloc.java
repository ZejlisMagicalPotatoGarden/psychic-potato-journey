package cartes.serviteurs;

import cartes.effets.Invocation;

public class Chasse_maree_murloc extends Serviteur {

	public Chasse_maree_murloc() {
		super("Chasse mar�e murloc", 2, "Neutre", 1, 2, new Invocation("Invocation d'un serviteur 1/1", "Invocation d'un eclaireur murloc", "entr�e", new Serviteur("Eclaireur murloc", 0, "neutre", 1,1, null), 1));
	}

}
