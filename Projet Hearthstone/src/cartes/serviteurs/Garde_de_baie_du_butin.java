package cartes.serviteurs;

import cartes.effets.Provocation;

public class Garde_de_baie_du_butin extends Serviteur {
	/**
	 * Classe représentant le serviteur Garde de baie du butin, permet un effet de provocation.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 */

	public Garde_de_baie_du_butin() {
		super("Garde de baie du butin", 5, "Neutre", 4,5, new Provocation());
	}

}
