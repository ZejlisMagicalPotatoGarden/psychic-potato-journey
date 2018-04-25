package cartes.effet.buff;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;;

public class Effet_buff extends Effet {

	private int bonusAttaque;
	private int bonusVie;
	private String nom;
	private String description;
	private String type;
	
	public Effet_buff(String description, String nom, String type, int bonusAttaque, int bonusVie) {
		super(description, nom, type);
		this.bonusAttaque = bonusAttaque;
		this.bonusVie = bonusVie;
		this.nom = nom;
		this.description = description;
		this.type = type;
	}

	
	
	public int getBonusAttaque() {
		return bonusAttaque;
	}
	public void setBonusAttaque(int bonusAttaque) {
		this.bonusAttaque = bonusAttaque;
	}
	public int getBonusVie() {
		return bonusVie;
	}
	public void setBonusVie(int bonusVie) {
		this.bonusVie = bonusVie;
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


	@Override
	public String toString() {
		return "Effet_buff [bonusAttaque=" + bonusAttaque + ", bonusVie=" + bonusVie + ", nom=" + nom + ", description="
				+ description + ", type=" + type + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effet_buff other = (Effet_buff) obj;
		if (bonusAttaque != other.bonusAttaque)
			return false;
		if (bonusVie != other.bonusVie)
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
	public void activer(Cible c) {
		c.augmenterVie(bonusVie);
		c.augmenterAttaque(bonusAttaque);
	}
	@Override
	public boolean isActivable(Cible c) {
		return !(c == null);
	}
	@Override
	public boolean isCiblable(){
		return true;
	}

}
