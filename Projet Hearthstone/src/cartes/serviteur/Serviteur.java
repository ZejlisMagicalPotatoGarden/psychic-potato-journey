package cartes.serviteur;

import cartes.carte.Carte;
import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;
import partie.autres.personnage.Personnage;

public class Serviteur extends Carte implements Personnage {

	private Effet effet;
	
	public Serviteur(String nom, int cout, String classe) {
		super(nom, cout, classe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prendreDegats(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mourir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jouerCarte() {
		// TODO Auto-generated method stub

	}
	
	public void invoquer(){
		
	}
	
	public void attaquer(Cible cible) {
		// TODO Auto-generated method stub
	}

}
