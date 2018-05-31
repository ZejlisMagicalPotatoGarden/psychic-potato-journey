package cartes.serviteurs;

import cartes.effets.Degats;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe repr�sentant le serviteur Gnome lepreux, permet un effet de d�g�t infligeant 2 points
 * de Serviteurpoint au h�ros adverse.
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 */

	public Gnome_lepreux() {
		super("Gnome l�preux", 1, "Neutre", 1, 1, new Degats("Inflige 2 points de d�g�ts au h�ros", "Attaque du l�preux", "Mort", 2));
	}

}
