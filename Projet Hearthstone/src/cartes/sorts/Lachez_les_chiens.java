package cartes.sorts;

import cartes.effets.E_Charge;
import cartes.effets.Effet;
import cartes.effets.Invocation;
import cartes.serviteurs.Serviteur;
import interfaceConsole.Interface;
import interfaceConsole.InterfaceCiblage;
import partie.autres.personnage.Personnage;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Lachez_les_chiens extends Sort {
	/**
	 * Classe repr�sentant le sort lachez les chiens, permet un effet d'invocation de deux chiens 1/1.
	 * Sp�cifique au chasseur.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Sort
	 */
	
	private Partie partie;
	
	public Lachez_les_chiens(Partie partie) {
		super("Lachez les chiens", 2, new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Imm�diat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), 0, partie), "Chasseur");
		this.partie = partie;
	}

	@Override
	public void jouerCarte(Plateau p){
		setEffet(new Invocation("Invoque autant de chiens que l'adversaire a de serviteurs", "Lachez les chiens", "Imm�diat", new Serviteur("Chien", 0, "Chasseur", 1,1, new E_Charge()), partie.getJoueurQuiJouePas().getPlateau().getServiteurs().size(), partie));
		try {
			getEffet().activer(null);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
