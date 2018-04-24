package partie.partie;

import partie.joueur.joueur.Joueur;

public class Partie {

	private Joueur joueur1;
	private Joueur joueur2;
	
	public Partie(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public Joueur getJoueur1() {
		return joueur1;
	}
	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	public Joueur getJoueur2() {
		return joueur2;
	}
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	@Override
	public String toString() {
		return "Partie [joueur1=" + joueur1 + ", joueur2=" + joueur2 + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		if (joueur1 == null) {
			if (other.joueur1 != null)
				return false;
		} else if (!joueur1.equals(other.joueur1))
			return false;
		if (joueur2 == null) {
			if (other.joueur2 != null)
				return false;
		} else if (!joueur2.equals(other.joueur2))
			return false;
		return true;
	}
	
	public static void Gagner(){
		System.out.println("Quelqu'un a gagné");
	}
	
}
