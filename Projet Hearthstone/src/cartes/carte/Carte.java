package cartes.carte;

public abstract class Carte {
/**
 * Classe abstraite repr�sentant une carte dans le jeu Hearthstone, elle poss�de un nom,
 * un co�t et une classe � laquelle elle appartient(mage, chasseur, neutre)
 * On peut jouer une carte
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Deck
 * @see Main
 * @see Serviteur
 * @see Sort
 */
	
	private String nom;
	private int cout;
	private String classe;
	

	public Carte(String nom, int cout, String classe) {
		super();
		this.nom = nom;
		this.cout = cout;
		this.classe = classe;
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

	
	public abstract void jouerCarte();
}
