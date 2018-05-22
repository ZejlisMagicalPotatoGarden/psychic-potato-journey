package cartes.sorts;

import cartes.effets.Invocation;
import cartes.effets.Provocation;
import cartes.serviteurs.Serviteur;

public class Image_mirroir extends Sort {
	/**
	 * Classe représentant le sort image miroir, permet un effet d'invocation de deux serviteurs de Jaina à 0/+2 possédant un effet de provocation
	 * Ce sort est spécifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see carte
	 * @see effets
	 * @see serviteurs
	 * @see sorts
	 */

	public Image_mirroir() {
		super("Image miroir", 1, new Invocation("Invoque deux serviteurs de Jaina 0/2 ayant provocation", "Image mirroir", "Immédiat", new Serviteur("Image miroir", 0, "mage", 2, 0, new Provocation()), 2), "Mage");
	}

}
