package cartes.effet.pioche;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;
import partie.joueur.joueur.Joueur;

public class Effet_pioche extends Effet {

	private Joueur joueur;
	private int nbPioche;
	private String description;
	private String nom;
	private String type;
	private boolean ciblable;
	
	
	public Effet_pioche(String description, String nom, String type, Joueur joueur,
			int nbPioche) {
		super(description, nom, type, false);
		this.nbPioche = nbPioche;
		this.joueur = joueur;
		this.description = description;
		this.nom = nom;
		this.type = type;
		this.ciblable = false;
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
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public int getNbPioche() {
		return nbPioche;
	}
	public void setNbPioche(int nbPioche) {
		this.nbPioche = nbPioche;
	}
	public boolean isCiblable() {
		return ciblable;
	}
	public void setCiblable(boolean ciblable) {
		this.ciblable = ciblable;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet_pioche other = (Effet_pioche) obj;
		if (ciblable != other.ciblable)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (nbPioche != other.nbPioche)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
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
		return "Effet_pioche [joueur=" + joueur + ", nbPioche=" + nbPioche + ", description=" + description + ", nom="
				+ nom + ", type=" + type + ", ciblable=" + ciblable + "]";
	}

	
	@Override
	public void activer(Cible c) {
		this.joueur.piocher(this.nbPioche);
	}

	@Override
	public boolean isActivable(Cible c) {
		return true;
	}

}
