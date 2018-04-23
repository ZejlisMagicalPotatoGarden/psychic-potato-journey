package cartes.sort;

import cartes.carte.Carte;
import cartes.effet.effet.Effet;

public class Sort extends Carte {

	private Effet effet;
	
	public Sort(String nom, int cout, Effet effet, String classe) {
		super(nom, cout, classe);
		this.effet = effet;
	}

	@Override
	public void jouerCarte() {
		// TODO Auto-generated method stub

	}

}
