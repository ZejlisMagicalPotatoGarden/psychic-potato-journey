package cartes.serviteurs;

import cartes.effets.Degats;

public class Gnome_lepreux extends Serviteur {

	public Gnome_lepreux() {
		super("Gnome l�preux", 1, "Neutre", 1, 1, new Degats("Inflige 2 points de d�g�ts au h�ros", "Attaque du l�preux", "Imm�diat", 2));
	}

}
