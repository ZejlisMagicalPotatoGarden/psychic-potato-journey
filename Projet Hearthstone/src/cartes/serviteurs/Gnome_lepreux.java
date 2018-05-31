package cartes.serviteurs;

import cartes.effets.Degats_heros_adverse;
import partie.partie.Partie;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe représentant le serviteur Gnome lepreux, permet un effet de dégât infligeant 2 points
 * de Serviteurpoint au héros adverse.
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 * @see Effet
 * @see Carte
 */

	public Gnome_lepreux(Partie p) {
		super("Gnome lépreux", 1, "Neutre", 1, 1, new Degats_heros_adverse("Inflige 2 points de dégâts au héros", "Attaque du lépreux", "Mort", 2, p));
	}

}
