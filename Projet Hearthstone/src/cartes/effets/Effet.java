package cartes.effets;

import partie.autres.personnage.Personnage;

public abstract class Effet {
/**
 * Classe abstraite représentant un effet quelconque, il possède un nom, une description et
 * un type(entrée, mort, attaque, immédiat ...)
 * Il peut etre activé sur un personnage
 * Les sorts, les pouvoirs et parfois les erviteurs possèdent des effets
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Serviteur
 * @see Sort
 * @see Pouvoir
 * @see Personnage
 */
	
	private String description;
	private String nom;
	private String type;

	
	public Effet(String description, String nom, String type) {
		setDescription(description);
		setNom(nom);
		setType(type);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet other = (Effet) obj;
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
		return "Effet [description=" + description + ", nom=" + nom + ", type=" + type + "]";
	}


	public abstract void activer(Personnage p) throws Exception;
	public abstract boolean isActivable();
	public abstract boolean isCiblable();

}
