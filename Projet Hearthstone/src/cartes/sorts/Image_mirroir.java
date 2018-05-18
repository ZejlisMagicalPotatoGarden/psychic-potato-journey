package cartes.sorts;

import cartes.effets.Effet;
import cartes.effets.Invocation;
import cartes.serviteurs.Serviteur;

public class Image_mirroir extends Sort {

	public Image_mirroir() {
		super("Image miroir", 1, new Invocation("Invoque deux serviteurs de Jaina 0/+2 ayant provocation", "Image mirroir", "Invocation", new Serviteur("Image miroir", 0, "?", ) , null, null), "Mage");
	}

}
