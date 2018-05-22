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
	 * @see effets
	 * @see sort
	 * @see serviteurs
	 */

	private Partie partie;
	private Serviteur serviteur;
	private String description;
	private String nom;
	private String type;
	private int nbInvocs;
	
	
	public Invocation(String description, String nom, String type, Serviteur serviteur, int nbInvocs) {
		super(description, nom, type);
		setServiteur(serviteur);
		setDescription(description);
		setNom(nom);
		setType(type);
		setPartie(null);
		setNbInvocs(nbInvocs);
	}
	
	
	public Serviteur getServiteur() {
		return serviteur;
	}
	public void setServiteur(Serviteur serviteur) {
		this.serviteur = serviteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nbInvocs != other.nbInvocs)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invocation [serviteur=" + serviteur + ", description=" + description + ", nom=" + nom + ", type=" + type
				+ ", nbInvocs=" + nbInvocs + "]";
	}


	@Override
	public void activer(Personnage p) {
		int i = 0;
		
		while(!this.partie.getJoueurQuiJoue().getPlateau().isPlein() && i < nbInvocs)
		{
			this.serviteur.invoquer(this.partie.getJoueurQuiJoue().getPlateau());
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
