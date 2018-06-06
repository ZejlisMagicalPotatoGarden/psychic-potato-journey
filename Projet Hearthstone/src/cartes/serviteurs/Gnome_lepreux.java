package cartes.serviteurs;

import cartes.effets.Degats_cible;
import cartes.effets.Degats_heros_adverse;
import partie.joueur.joueur.Joueur;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Gnome_lepreux extends Serviteur {
/**
 * Classe représentant le serviteur Gnome lepreux, permet un effet de dégât infligeant 2 points
 * de dégats au héros adverse. Comme il peut mourir pendant n'importe quel tour, il faut sauvegarder le joueur
 * qui va prendre les dégats
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 */

	private Joueur jCible;
	
	public Gnome_lepreux(Partie p) {
		super("Gnome lépreux", 1, "Neutre", 1, 1, new Degats_cible("Inflige 2 points de dégâts au héros", "Attaque du lépreux", "Mort", 2));
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
