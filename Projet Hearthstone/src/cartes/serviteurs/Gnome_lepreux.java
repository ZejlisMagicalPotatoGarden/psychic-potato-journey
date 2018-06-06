package cartes.serviteurs;

import cartes.effets.Degats_cible;
import cartes.effets.Degats_heros_adverse;
import partie.joueur.joueur.Joueur;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe repr�sentant le serviteur Gnome lepreux, permet un effet de d�g�t infligeant 2 points
 * de d�gats au h�ros adverse. Comme il peut mourir pendant n'importe quel tour, il faut sauvegarder le joueur
 * qui va prendre les d�gats
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 */

	private Joueur jCible;
	
	public Gnome_lepreux(Partie p) {
		super("Gnome l�preux", 1, "Neutre", 1, 1, new Degats_cible("Inflige 2 points de d�g�ts au h�ros", "Attaque du l�preux", "Mort", 2));
	}

	@Override
	public void jouerCarte(Partie p) throws Exception{
		jCible = p.getJoueurQuiJouePas();
		invoquer(p.getJoueurQuiJoue().getPlateau());
	}
	
	@Override
	public void mourir(Joueur j) throws Exception{
		System.out.printf("%s est mort\n",super.getNom());
		this.getEffet().activer(jCible.getHeros());
		j.getPlateau().removeServiteur(this);
	}
}
