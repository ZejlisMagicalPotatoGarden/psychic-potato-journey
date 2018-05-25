package partie.partie;

import partie.joueur.joueur.Joueur;

public class Partie {
	/**
	 * Classe représentant une partie, elle est composée de deux joueurs qui s'affrontent,
	 * ainsi qu'un booléen permettant de savoir qui à la main.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see joueur
	 * @see partie
	 */

	private Joueur joueur1;
	private Joueur joueur2;
	private boolean tourJ1; 
	
	public Partie(Joueur joueur1, Joueur joueur2) {
		setJoueur1(joueur1);
		setJoueur2(joueur2);
		setTourJ1(true);
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
	public boolean isTourJ1() {
		return tourJ1;
	}
	public void setTourJ1(boolean tourJ1) {
		this.tourJ1 = tourJ1;
	}

	
	@Override
	public String toString() {
		return "Partie [joueur1=" + joueur1 + ", joueur2=" + joueur2 + ", tourJ1=" + tourJ1 + "]";
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
		if (tourJ1 != other.tourJ1)
			return false;
		return true;
	}

	
	public static void Gagner(Joueur gagnant){
		System.out.printf("%s (%s) a gagné\n",gagnant,gagnant.getHeros().getNom());
	}
	public Joueur getJoueurQuiJoue(){
		if(this.tourJ1)
			return this.joueur1;
		else
			return this.joueur2;
	}
	public Joueur getJoueurQuiJouePas(){
		if(this.tourJ1)
			return this.joueur2;
		else
			return this.joueur1;
	}
}
