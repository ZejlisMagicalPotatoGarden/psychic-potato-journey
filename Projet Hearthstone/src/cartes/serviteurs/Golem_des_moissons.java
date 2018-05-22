package cartes.serviteurs;

import cartes.effets.Invocation;

public class Golem_des_moissons extends Serviteur {

	public Golem_des_moissons() {
		super("Golem des moissons", 3, "Neutre", 3, 2, new Invocation("Invoque un Golem endomagé 2/1", "Golémisation", "Mort", new Serviteur("Golem endomagé", 0, "Neutre", 1, 2, null), 1));
	}

}
