package interfaceConsole;

import cartes.serviteurs.Serviteur;
import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class InterfaceChoixEnnemiAttaque extends Interface {

	private Personnage personnage;
	private Serviteur attaquant;
	
	
	public InterfaceChoixEnnemiAttaque(Interface ihm, Personnage personnage, Serviteur attaquant) {
		super(ihm);
		this.personnage = personnage;
		this.attaquant = attaquant;
	}
	
	public Personnage getPersonnage() {
		return personnage;
	}
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	@Override
	public String toString() {
		return "InterfaceChoixEnnemiAttaque [personnage=" + personnage + ", attaquant=" + attaquant + "]";
	}

	@Override
	public String getDescription() {
		return "Attaquer "+personnage+" avec "+attaquant;
	}
	
	@Override
	public void executerInteraction(Partie p) throws Exception {
		attaquant.attaquer(personnage);
	}
}
