package interfaceConsole;

import cartes.carte.Carte;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class interfaceChoixCarteAJouer extends Interface {

	private Carte carte;

	public interfaceChoixCarteAJouer(Interface ihm, Carte carte) {
		super(ihm);
		setCarte(carte);
	}

	
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}


	@Override
	public String getDescription() {
		return "Jouer "+ carte;
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		
		jQuiJoue.getMain().jouerCarte(carte.getNom(), jQuiJoue.getPlateau());
	}

}
