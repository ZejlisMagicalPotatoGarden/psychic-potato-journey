package cartes.effets;

import cartes.serviteurs.Serviteur;
import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class Degats_serviteurs_adverses extends Degats {
	/**
	 * Classe repr�sentant l'effet d�g�ts_serviteurs_adverses qui inflige des d�gats �
	 * tous les serviteurs adverses
	 * H�rite de d�gats.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Degats
	 */
	
	private Partie partie;
	
	public Degats_serviteurs_adverses(String description, String nom, String type, int nbDegats, Partie partie) {
		super(description, nom, type, nbDegats);
		this.partie = partie;
	}

	
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	
	
	@Override
	public boolean isCiblable() {
		return false;
	}

	@Override
	public void activer(Personnage p) {
		for(Serviteur s : partie.getJoueurQuiJouePas().getPlateau().getServiteurs())
		{
			s.prendreDegats(getNbDegats());
		}
		
	}
}
