package cartes.carte;

import cartes.effets.Effet;
import partie.joueur.plateau.Plateau;

public abstract class Carte {
/**
 * Classe abstraite représentant une carte dans le jeu Hearthstone, elle possède un nom,
 * un coût et une classe à laquelle elle appartient(mage, chasseur, neutre)
 * On peut jouer une carte et vérifier qu'elle est jouable
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 */
	
	private String nom;
	private int cout;
	private String classe;
	

	public Carte(String nom, int cout, String classe) {
		setNom(nom);
		setCout(cout);
		setClasse(classe);
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
	
	@Override
	public String toString() {
		return "Carte [nom=" + nom + ", cout=" + cout + ", classe=" + classe + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (cout != other.cout)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
	public abstract void jouerCarte(Plateau p) throws Exception;
	public abstract boolean isJouable(Plateau p);
	public abstract boolean checkEffet(String type);
	public abstract Effet getEffet();
}

