package cartes.sorts;

import cartes.effets.Invocation;
import cartes.effets.Provocation;
import cartes.serviteurs.Serviteur;

public class Image_mirroir extends Sort {

	public Image_mirroir() {
		super("Image miroir", 1, new Invocation("Invoque deux serviteurs de Jaina 0/2 ayant provocation", "Image mirroir", "Immédiat", new Serviteur("Image miroir", 0, "mage", 2, 0, new Provocation()), 2), "Mage");
	}

}
