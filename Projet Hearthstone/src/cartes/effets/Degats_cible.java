package cartes.effets;

import partie.autres.personnage.Personnage;

public class Degats_cible extends Degats {
	/**
	 * Classe repr�sentant l'effet d�g�ts cible qui inflige des d�gats � une cible choisie par l'utilisateur
	 * H�rite de d�gats.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 */
	
	public Degats_cible(String description, String nom, String type, int nbDegats) {
		super(description, nom, type, nbDegats);
	}


	@Override
	public void activer(Personnage p) {
		p.prendreDegats(getNbDegats());
	}

	@Override
	public boolean isCiblable() {
		return true;
	}
}
