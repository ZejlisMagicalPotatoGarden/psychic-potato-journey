package cartes.serviteurs;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe repr�sentant le serviteur Gnome lepreux, permet un effet de d�g�t infligeant 2 points
 * de Serviteurpoint au h�ros adverse.
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see serviteurs
 * @see effets
 * 
 * @param nom
 * @param cout
 * @param classe
 * @param vieMax
 * @param attaque
 * @param effet
 */

	public Gnome_lepreux(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Gnome l�preux", 1, "Neutre", 1, 1, new Degats("Inflige 2 Serviteurpoints de d�g�ts au h�ros", "Attaque du l�preux", "Imm�diat", 2));
	}

}
