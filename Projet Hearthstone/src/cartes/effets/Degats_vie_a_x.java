package cartes.effets;

import partie.autres.personnage.Personnage;

public class Degats_vie_a_x extends Degats {
	/**
	 * Classe repr�sentant l'effet d�g�ts_vie_a_x qui met les pv de la cible a nbDegats
	 * H�rite de d�gats.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Degats
	 */
	
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
