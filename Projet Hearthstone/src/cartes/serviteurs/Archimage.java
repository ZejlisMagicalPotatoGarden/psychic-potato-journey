package cartes.serviteurs;

import cartes.effets.Provocation;

public class Archimage extends Serviteur {
	/**
	 * Classe représentant le serviteur Archimage, porte la capacité provocation.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 */
	public Archimage() {
		super("Archimage", 6, "Neutre", 7, 4, new Provocation());
	}

}
