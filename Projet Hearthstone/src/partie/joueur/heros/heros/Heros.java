package partie.joueur.heros.heros;

import partie.autres.personnage.Personnage;
import partie.joueur.heros.pouvoir.Pouvoir;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class Heros implements Personnage {
	/**
	 * Classe représentant un héros, elle implémente l'interface Personnage
	 * un héros peut être un mage ou un chasseur. Il possède un nom, de la vie et un pouvoir.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see heros
	 * @see chasseur
	 * @see mage
	 */

	//VIE MAX ?------------------------------------
	private String nom;
	private int vie;
	private Pouvoir pouvoir;

	public Heros(String nom, int vie, Pouvoir pouvoir) {
		setNom(nom);
		setVie(vie);
		setPouvoir(pouvoir);
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
		return "Heros [nom=" + nom + ", vie=" + vie + ", pouvoir=" + pouvoir + "]";
	}

	
	@Override
	public void prendreDegats(int x) {
		this.vie = this.vie - x;
	}

	@Override
	public void mourir(Joueur j) {
		Partie.Gagner(j);
	}

	
	@Override
	public void augmenterAttaque(int bonusAttaque) {
		//Un héros n'a pas d'attaque pour l'instant
	}
	@Override
	public void augmenterVie(int bonusVie) {
		//Un héros ne gagne pas de vie max pour l'instant
	}

	@Override
	public int getAttaque() {
		//Un héros n'a pas d'attaque
		return 0;
	}

}
