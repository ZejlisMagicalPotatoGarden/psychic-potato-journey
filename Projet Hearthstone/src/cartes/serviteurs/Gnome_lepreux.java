package cartes.serviteurs;

import cartes.effets.Degats;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe représentant le serviteur Gnome lepreux, permet un effet de dégât infligeant 2 points
 * de Serviteurpoint au héros adverse.
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see serviteurs
 * @see effets
 * @see carte
 * 
 * @param nom
 * @param cout
 * @param classe
 * @param vieMax
 * @param attaque
 * @param effet
 */

	public Gnome_lepreux() {
		super("Gnome lépreux", 1, "Neutre", 1, 1, new Degats("Inflige 2 points de dégâts au héros", "Attaque du lépreux", "Immédiat", 2));
	}

}
