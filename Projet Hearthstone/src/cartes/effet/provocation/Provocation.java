package cartes.effet.provocation;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;

public class Provocation extends Effet {

	private String description;
	private String nom;
	private String type;
	private boolean ciblable;
	
	
	public Provocation() {
		super("Empeche les serviteurs d'attaquer le h�ros","Provocation","Provocation",false);
		this.description = "Empeche les serviteurs d'attaquer le h�ros";
		this.nom = "Provocation";
		this.type = "Provocation";
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
		Provocation other = (Provocation) obj;
		if (ciblable != other.ciblable)
			return false;
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
		return "Provocation [description=" + description + ", nom=" + nom + ", type=" + type + ", ciblable=" + ciblable
				+ "]";
	}

	
	@Override
	public void activer(Cible c) {
		//Cet effet ne s'active jamais
	}

	@Override
	public boolean isActivable(Cible c) {
		//cet effet ne s'active jamais
		return false;
	}
}