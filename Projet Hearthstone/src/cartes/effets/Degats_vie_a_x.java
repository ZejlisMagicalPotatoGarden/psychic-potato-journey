package cartes.effets;

import partie.autres.personnage.Personnage;

public class Degats_vie_a_x extends Degats {

	public Degats_vie_a_x(String description, String nom, String type, int nbDegats) {
		super(description, nom, type, nbDegats);
	}

	@Override
	public boolean isCiblable() {
		return true;
	}

	@Override
	public void activer(Personnage p) {
		p.setVie(getNbDegats());
	}

}
