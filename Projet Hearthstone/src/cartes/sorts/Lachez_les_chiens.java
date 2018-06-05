package cartes.sorts;

import cartes.effets.E_Charge;
import cartes.effets.Invocation;
import cartes.serviteurs.Serviteur;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Lachez_les_chiens extends Sort {
	/**
	 * Classe représentant le sort lachez les chiens, permet un effet d'invocation de deux chiens 1/1.
	 * Spécifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */
	
	
	public Lachez_les_chiens(Partie partie) {
		super("Lachez les chiens", 2, new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Immédiat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), 0, partie), "Chasseur");
	}

	@Override
	public void jouerCarte(Partie p){
		setEffet(new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Immédiat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), p.getJoueurQuiJouePas().getPlateau().getServiteurs().size(), p));
		try {
			getEffet().activer(null);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
