package cartes.serviteurs;

import cartes.effets.Provocation;

public class Archimage extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur Archimage, porte la capacit� provocation.
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
