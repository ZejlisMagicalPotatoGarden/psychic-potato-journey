package interfaceConsole;

import cartes.carte.Carte;
import cartes.serviteur.Serviteur;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class InterfaceJouerCarte extends Interface {

	public InterfaceJouerCarte(Interface ihm) {
		super(ihm);
	}

	
	@Override
	public String getDescription() {
		return "Jouer une carte de votre main";
	}

	@Override
	public boolean saisInteragir(String actionDemandee) {
		return actionDemandee.equals("Jouer une carte de votre main");
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		
		if(jQuiJoue.getMain().getCartes().isEmpty())
			System.out.println("Vous n'avez pas de cartes en main");
		else
		{
			int i = 1;
			System.out.println("Quelle carte ?");
			for(Carte c : jQuiJoue.getMain().getCartes())
			{
				System.out.printf("%d. %s\n",i,c.getNom());
				i++;
			}
		}
	}

}
