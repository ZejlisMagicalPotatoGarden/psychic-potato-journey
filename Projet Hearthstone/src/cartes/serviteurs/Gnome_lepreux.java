package cartes.serviteurs;

import cartes.effets.Degats;

public class Gnome_lepreux extends Serviteur {

	public Gnome_lepreux() {
		super("Gnome lépreux", 1, "Neutre", 1, 1, new Degats("Inflige 2 points de dégâts au héros", "Attaque du lépreux", "Immédiat", 2));
	}

}
