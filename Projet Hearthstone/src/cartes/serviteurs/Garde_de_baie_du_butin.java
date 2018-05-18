package cartes.serviteurs;

import cartes.effets.Effet;
import cartes.effets.Provocation;

public class Garde_de_baie_du_butin extends Serviteur {

	public Garde_de_baie_du_butin(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Garde de baie du butin", 5, "Neutre", 4,5, new Provocation());
	}

}
