package interfaceConsole;

import cartes.serviteurs.Serviteur;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class InterfaceAttaquer extends Interface {

	public InterfaceAttaquer(Interface ihm) {
		super(ihm);
	}

	
	@Override
	public String getDescription() {
		return "Attaquer un adversaire avec un de vos serviteurs";
	}

	@Override
	public boolean saisInteragir(String actionDemandee) {
		return actionDemandee.equals("Attaquer un adversaire avec un de vos serviteurs");
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		if(jQuiJoue.getPlateau().getServiteurs().isEmpty())
			System.out.println("Vous n'avez pas de serviteurs capables d'attaquer");
		else
		{
			int i = 1;
			System.out.println("Avec quel serviteur ?");
			for(Serviteur s : jQuiJoue.getPlateau().getServiteurs())
			{
				System.out.printf("%d. %s : %d attaque, %d point(s) de vie\n",i,s.getNom(),s.getAttaque(),s.getVie());
				i++;
			}
		}

	}

}
