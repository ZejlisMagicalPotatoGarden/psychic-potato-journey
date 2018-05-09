package cartes.effets;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;

public class Effet_modele extends Effet {

	private String description;
	private String nom;
	private String type;
	
	public Effet_modele() {
		super("Ne fait rien parce que c'est un modèle", "Effet modèle", "Entrée/Mort/Aura/...");
		this.description = "Ne fait rien parce que c'est un modèle";
		this.nom = "Effet modèle";
		this.type = "Entrée/Mort/Aura/Immédiat";
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

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet_modele other = (Effet_modele) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Effet_modele [description=" + description + ", nom=" + nom + ", type=" + type + "]";
	}


	@Override
	public void activer(Cible c) {
		//Fait un truc normalement
	}
	@Override
	public boolean isActivable(Cible c) {
		return false;
	}
	@Override
	public boolean isCiblable() {
		return false;
	}

}
