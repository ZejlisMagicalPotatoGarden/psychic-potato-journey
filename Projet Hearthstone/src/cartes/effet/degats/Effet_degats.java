package cartes.effet.degats;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;
import partie.autres.personnage.Personnage;

public class Effet_degats extends Effet {

	private int nbDegats;
	private String description;
	private String nom;
	private String type;
	private boolean ciblable;
	
	
	public Effet_degats(String description, String nom, String type, int nbDegats) {
		super(description, nom, type, true);
		this.nbDegats = nbDegats;
		this.description = description;
		this.nom = nom;
		this.type = type;
		this.ciblable = true;
	}
	
	public int getNbDegats() {
		return nbDegats;
	}
	public void setNbDegats(int nbDegats) {
		this.nbDegats = nbDegats;
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
		Effet_degats other = (Effet_degats) obj;
		if (ciblable != other.ciblable)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nbDegats != other.nbDegats)
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
		return "Effet_degats [nbDegats=" + nbDegats + ", description=" + description + ", nom=" + nom + ", type=" + type
				+ ", ciblable=" + ciblable + "]";
	}

	
	@Override
	public void activer(Cible c) {
		for(Personnage s : c.getCibles()){
			s.prendreDegats(nbDegats);
		}
	}

	@Override
	public boolean isActivable(Cible c) {
		return !(c == null);
	}

}
