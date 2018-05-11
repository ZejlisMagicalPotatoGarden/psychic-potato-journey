package cartes.effets;

import cartes.serviteurs.Serviteur;
import partie.autres.cible.Cible;
import partie.partie.Partie;

public class Invocation extends Effet {

	private Partie partie;
	private Serviteur serviteur;
	private String description;
	private String nom;
	private String type;
	
	
	public Invocation(String description, String nom, String type, Serviteur serviteur, 
			Partie partie) {
		super(description, nom, type);
		setServiteur(serviteur);
		setDescription(description);
		setNom(nom);
		setType(type);
		setPartie(partie);
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
		return "Effet_invocation [partie=" + partie + ", serviteur=" + serviteur + ", description=" + description
				+ ", nom=" + nom + ", type=" + type + "]";
	}


	@Override
	public void activer(Cible c) {
		this.serviteur.invoquer(this.partie.getJoueurQuiJoue().getPlateau());
	}
	@Override
	public boolean isActivable(Cible c) {
		return !(this.partie.getJoueurQuiJoue().getPlateau().isPlein());
	}
	@Override
	public boolean isCiblable(){
		return false;
	}

}
