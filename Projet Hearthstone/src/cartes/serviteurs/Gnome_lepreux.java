package cartes.serviteurs;

import cartes.effets.Degats;
import cartes.effets.Effet;

public class Gnome_lepreux extends Serviteur {

	public Gnome_lepreux(String nom, int cout, String classe, int vieMax, int attaque, Effet effet) {
		super("Gnome l�preux", 1, "Neutre", 1, 1, new Degats("Inflige 2 Serviteurpoints de d�g�ts au h�ros", "Attaque du l�preux", "Imm�diat", 2));
	}

}
