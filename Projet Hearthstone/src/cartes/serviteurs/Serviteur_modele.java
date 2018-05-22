package cartes.serviteurs;

import cartes.effets.Effet_modele;

public class Serviteur_modele extends Serviteur {
	/**
	 * Classe servant à tester, elle ne sera pas utilisée autrement.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see serviteurs
	 * @see effets
	 */

	public Serviteur_modele() {
		super("Serviteur modèle", 0, "Neutre", 0, 0, new Effet_modele());
	}
}
