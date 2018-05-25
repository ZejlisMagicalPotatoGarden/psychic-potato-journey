package cartes.serviteurs;

import cartes.effets.Invocation;
import partie.partie.Partie;

public class Chasse_maree_murloc extends Serviteur {
	/**
	 * Classe repr�sentant le serviteur Chasse mar�e murloc permettant d'invoquer un serviteur +1/+1.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * @see Effet
	 * @see Carte
	 * 
	 */

	public Chasse_maree_murloc(Partie partie) {
		super("Chasse mar�e murloc", 2, "Neutre", 1, 2, new Invocation("Invocation d'un serviteur 1/1", "Invocation d'un eclaireur murloc", "Entr�e", new Serviteur("Eclaireur murloc", 0, "neutre", 1,1, null), 1, partie));
	}

}
