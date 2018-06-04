package cartes.effets;

import partie.autres.personnage.Personnage;

public class Degats_cible extends Degats {
	/**
	 * Classe représentant l'effet dégâts cible qui inflige des dégats à une cible choisie par l'utilisateur
	 * Hérite de dégats.
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
