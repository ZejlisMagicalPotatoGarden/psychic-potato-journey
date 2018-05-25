package cartes.sorts;

import cartes.effets.Degats;

public class Ordre_de_tuer extends Sort {
	/**
	 * Classe repr�sentant le sort ordre de tuer, permet un effet de d�g�ts infligeant 3 points de d�g�ts au personnage cibl�.
	 * Sp�cifique au chasseur.
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
		super("Ordre de tuer", 3, new Degats("Inflige 3 points de d�g�ts au personnage cibl�", "Ordre de tuer", "Imm�diat", 3), "Mage");
	}

}
