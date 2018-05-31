package cartes.sorts;

import cartes.effets.Invocation;
import cartes.effets.Provocation;
import cartes.serviteurs.Serviteur;
import partie.partie.Partie;

public class Image_mirroir extends Sort {
	/**
	 * Classe repr�sentant le sort image miroir, permet un effet d'invocation de deux serviteurs de Jaina � 0/+2 poss�dant un effet de provocation
	 * Ce sort est sp�cifique au mage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * @see Sort
	 */

	public Image_mirroir(Partie partie) {
		super("Image miroir", 1, new Invocation("Invoque deux serviteurs de Jaina 0/2 ayant provocation", "Image mirroir", "Imm�diat", new Serviteur("Image miroir", 0, "mage", 2, 0, new Provocation()), 2, partie), "Mage");
	}

}
