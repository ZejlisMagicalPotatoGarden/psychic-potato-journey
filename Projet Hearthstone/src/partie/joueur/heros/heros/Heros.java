package partie.joueur.heros.heros;

import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class Heros implements Personnage {

	private String nom;
	private int vie;

	public Heros(String nom, int vie) {
		super();
		this.nom = nom;
		this.vie = vie;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heros other = (Heros) obj;
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
		return "Heros [nom=" + nom + ", vie=" + vie + "]";
	}

	
	@Override
	public void prendreDegats(int x) {
		setVie(getVie() - x);
	}

	@Override
	public void mourir() {
		Partie.Gagner();
	}

	
	@Override
	public void augmenterAttaque(int bonusAttaque) {
		//Un héros n'a pas d'attaque pour l'instant
	}
	@Override
	public void augmenterVie(int bonusVie) {
		//Un héros ne gagne pas de vie max pour l'instant
		
	}

}
