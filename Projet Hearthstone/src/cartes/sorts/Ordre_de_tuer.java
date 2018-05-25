package cartes.sorts;

import cartes.effets.Degats;

public class Ordre_de_tuer extends Sort {
	/**
	 * Classe représentant le sort ordre de tuer, permet un effet de dégâts infligeant 3 points de dégâts au personnage ciblé.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 * @see Carte
	 * 
	 * @param nom Nom du sort
	 * @param cout Cout en mana
	 * @param effet Effet
	 * @param classe Neutre, mage ou chasseur
	 */

	public Ordre_de_tuer() {
		super("Ordre de tuer", 3, new Degats("Inflige 3 points de dégâts au personnage ciblé", "Ordre de tuer", "Immédiat", 3), "Mage");
	}

}
