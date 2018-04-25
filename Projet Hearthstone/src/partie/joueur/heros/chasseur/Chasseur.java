package partie.joueur.heros.chasseur;

import partie.joueur.heros.heros.Heros;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Chasseur extends Heros {

	private int vie;
	private String nom;
	private Pouvoir pouvoir;
	
	public Chasseur(){
		super("Rexxar",15,new Pouvoir_chasseur());
		this.nom = "Rexxar";
		this.vie = 15;
		this.pouvoir = new Pouvoir_chasseur();
	}

	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Pouvoir getPouvoir() {
		return pouvoir;
	}
	public void setPouvoir(Pouvoir pouvoir) {
		this.pouvoir = pouvoir;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chasseur other = (Chasseur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pouvoir == null) {
			if (other.pouvoir != null)
				return false;
		} else if (!pouvoir.equals(other.pouvoir))
			return false;
		if (vie != other.vie)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chasseur [vie=" + vie + ", nom=" + nom + ", pouvoir=" + pouvoir + "]";
	}
	
}

