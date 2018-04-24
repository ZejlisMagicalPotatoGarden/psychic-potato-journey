package partie.joueur.heros.chasseur;

import partie.joueur.heros.heros.Heros;

public class Chasseur extends Heros {

	private int vie = 15;
	private String nom = "Jaina Portvaillant";
	
	public Chasseur(){
		super("Rexxar",15);
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
		if (vie != other.vie)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chasseur [vie=" + vie + ", nom=" + nom + "]";
	}
	
}

