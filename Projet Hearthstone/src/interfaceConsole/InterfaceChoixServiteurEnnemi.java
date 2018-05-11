package interfaceConsole;

import cartes.serviteurs.Serviteur;
import partie.partie.Partie;

public class InterfaceChoixServiteurEnnemi extends Interface {

private Serviteur serviteur;
	
	public InterfaceChoixServiteurEnnemi(Interface ihm, Serviteur serviteur) {
		super(ihm);
		setServiteur(serviteur);
	}

	
	public Serviteur getServiteur() {
		return serviteur;
	}
	public void setServiteur(Serviteur serviteur) {
		this.serviteur = serviteur;
	}

	@Override
	public String getDescription() {
		return "Prendre "+ serviteur +" comme cible de l'attaque";
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		// TODO Auto-generated method stub

	}

}
