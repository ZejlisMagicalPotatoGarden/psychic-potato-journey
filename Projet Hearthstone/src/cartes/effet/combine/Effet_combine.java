package cartes.effet.combine;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;

public class Effet_combine extends Effet {

	private String nom;
	private String description;
	private String type;
	private boolean ciblable;
	private Effet effet1;
	private Effet effet2;
	
	public Effet_combine(String description, String nom, String type, Effet effet1, Effet effet2) {
		super(description, nom, type);
		this.effet1 = effet1;
		this.effet2 = effet2;
		this.description = description;
		this.nom = nom;
		this.type = type;
		this.effet1.isCiblable() //---PAS FINI----------
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Effet getEffet1() {
		return effet1;
	}
	public void setEffet1(Effet effet1) {
		this.effet1 = effet1;
	}
	public Effet getEffet2() {
		return effet2;
	}
	public void setEffet2(Effet effet2) {
		this.effet2 = effet2;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet_combine other = (Effet_combine) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (effet1 == null) {
			if (other.effet1 != null)
				return false;
		} else if (!effet1.equals(other.effet1))
			return false;
		if (effet2 == null) {
			if (other.effet2 != null)
				return false;
		} else if (!effet2.equals(other.effet2))
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
		return "Effet_combine [nom=" + nom + ", description=" + description + ", type=" + type + ", effet1=" + effet1
				+ ", effet2=" + effet2 + "]";
	}

	
	@Override
	public void activer(Cible c) {
		effet1.activer(c);
		effet2.activer(c);
	}

	@Override
	public boolean isActivable(Cible c) {
		return effet1.isActivable(c) && effet2.isActivable(c);
	}

}
