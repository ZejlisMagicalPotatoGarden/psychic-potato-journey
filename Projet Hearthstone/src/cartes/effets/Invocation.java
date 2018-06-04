package cartes.effets;

import cartes.serviteurs.Serviteur;
import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class Invocation extends Effet {
	/**
	 * Classe représentant l'effet invocation, sert à invoquer un ou plusieurs serviteurs,
	 * elle a besoin de la partie en cours, du serviteur à invoquer, d'une description, d'un nom
	 * et d'un type.
	 * Les héros utilisent ce genre d'effet par l'intermédiaire d'un sort.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 * @see Sort
	 * @see Serviteur
	 */

	private Partie partie;
	private Serviteur serviteur;
	private int nbInvocs;
	
	
	public Invocation(String description, String nom, String type, Serviteur serviteur, int nbInvocs, Partie partie) {
		super(description, nom, type);
		setServiteur(serviteur);
		setNbInvocs(nbInvocs);
		setPartie(partie);
	}
	
	
	public Serviteur getServiteur() {
		return serviteur;
	}
	public void setServiteur(Serviteur serviteur) {
		this.serviteur = serviteur;
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	public int getNbInvocs() {
		return nbInvocs;
	}
	public void setNbInvocs(int nbInvocs) {
		this.nbInvocs = nbInvocs;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invocation other = (Invocation) obj;
		if (nbInvocs != other.nbInvocs)
			return false;
		if (partie == null) {
			if (other.partie != null)
				return false;
		} else if (!partie.equals(other.partie))
			return false;
		if (serviteur == null) {
			if (other.serviteur != null)
				return false;
		} else if (!serviteur.equals(other.serviteur))
			return false;
		return true;
	}


	@Override
	public void activer(Personnage p) {
		int i = 0;
		Serviteur s;
		
		while(!this.partie.getJoueurQuiJoue().getPlateau().isPlein() && i < nbInvocs)
		{
			s = new Serviteur(serviteur);
			s.invoquer(this.partie.getJoueurQuiJoue().getPlateau());
			i++;
		}
	}
	@Override
	public boolean isActivable() {
		return !(this.partie.getJoueurQuiJoue().getPlateau().isPlein());
	}
	@Override
	public boolean isCiblable(){
		return false;
	}

}
