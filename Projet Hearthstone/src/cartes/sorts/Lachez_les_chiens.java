package cartes.sorts;

import cartes.effets.E_Charge;
import cartes.effets.Effet;
import cartes.effets.Invocation;
import cartes.serviteurs.Serviteur;
import partie.partie.Partie;

public class Lachez_les_chiens extends Sort {
	/**
	 * Classe représentant le sort lachez les chiens, permet un effet d'invocation de deux chiens 1/1.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 * @see Carte
	 * @see Serviteur
	 * 
	 * @param nom Nom du sort
	 * @param cout Cout en mana
	 * @param effet Effet
	 * @param classe Neutre, mage ou chasseur
	 */

	public Lachez_les_chiens(Partie partie) {
		super("Lachez les chiens", 2, new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Immédiat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), partie.getJoueurQuiJouePas().getPlateau().getServiteurs().size(), partie), "Chasseur");
	}

}
