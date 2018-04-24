package cartes.effet.effet;

import partie.autres.cible.Cible;

public abstract class Effet {
/**
 * Classe abstraite repr�sentant un effet quelconque, il poss�de un nom, une description et
 * un type(entr�e, mort, attaque, imm�diat ...)
 * Il peut etre activ� sur une cible
 * Les sorts, les pouvoirs et parfois les erviteurs poss�dent des effets
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 * @see Sort
 * @see Pouvoir
 * @see Personnage
 * @see Cible
 */
	
	private String description;
	private String nom;
	private String type;
	private boolean ciblable;

	
	public Effet(String description, String nom, String type, boolean ciblable) {
		super();
		this.description = description;
		this.nom = nom;
		this.type = type;
		this.ciblable = ciblable;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet other = (Effet) obj;
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
		return "Effet [description=" + description + ", nom=" + nom + ", type=" + type + ", ciblable=" + ciblable + "]";
	}


	public abstract void activer(Cible c);
	public abstract boolean isActivable(Cible c);

}