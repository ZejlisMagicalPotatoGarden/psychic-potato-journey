package cartes.sorts;

import cartes.effets.E_Charge;
import cartes.effets.Effet;
import cartes.effets.Invocation;
import cartes.serviteurs.Serviteur;

public class Lachez_les_chiens extends Sort {
	/**
	 * Classe repr�sentant le sort lachez les chiens, permet un effet d'invocation de deux chiens 1/1.
	 * Sp�cifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 * @see carte
	 * @see sorts
	 * @see serviteurs
	 * 
	 * @param nom
	 * @param cout
	 * @param effet
	 * @param classe
	 */

	//CREER UN NOUVEAU TYPE D'EFFET POUR CA
	public Lachez_les_chiens(String nom, int cout, Effet effet, String classe) {
		super("Lachez les chiens", 2, new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Imm�diat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), 0), "Chasseur");
	}

}
