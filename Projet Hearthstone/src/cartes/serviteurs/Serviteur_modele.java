package cartes.serviteurs;

import cartes.effet.effet.Effet;
import cartes.effets.Effet_modele;
import cartes.serviteur.Serviteur;

public class Serviteur_modele extends Serviteur {

	private String nom;
	private int cout;
	private String classe;
	
	private int vieMax;
	private int vie;
	private int attaque;
	private Effet effet;
	
	public Serviteur_modele() {
		super("Serviteur modèle", 0, "Neutre", 0, 0, new Effet_modele());
		this.nom = "Serviteur modèle";
		this.cout = 0;
		this.classe = "Neutre";
		this.vieMax = 0;
		this.vie = 0;
		this.attaque = 0;
		this.effet = new Effet_modele();
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getVieMax() {
		return vieMax;
	}
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	public Effet getEffet() {
		return effet;
	}
	public void setEffet(Effet effet) {
		this.effet = effet;
	}


	@Override
	public String toString() {
		return "Serviteur_modele [nom=" + nom + ", cout=" + cout + ", classe=" + classe + ", vieMax=" + vieMax
				+ ", vie=" + vie + ", attaque=" + attaque + ", effet=" + effet + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serviteur_modele other = (Serviteur_modele) obj;
		if (attaque != other.attaque)
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (cout != other.cout)
			return false;
		if (effet == null) {
			if (other.effet != null)
				return false;
		} else if (!effet.equals(other.effet))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (vie != other.vie)
			return false;
		if (vieMax != other.vieMax)
			return false;
		return true;
	}
}
