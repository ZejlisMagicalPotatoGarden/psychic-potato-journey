package cartes.effets;

import partie.autres.cible.Cible;
import partie.joueur.joueur.Joueur;

public class Pioche extends Effet {

	private Joueur joueur;
	private int nbPioche;
	
	public Pioche(String description, String nom, String type, Joueur joueur,
			int nbPioche) {
		super(description, nom, type);
		setNbPioche(nbPioche);
		setJoueur(joueur);
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public int getNbPioche() {
		return nbPioche;
	}
	public void setNbPioche(int nbPioche) {
		this.nbPioche = nbPioche;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pioche other = (Pioche) obj;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (nbPioche != other.nbPioche)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Effet_pioche [joueur=" + joueur + ", nbPioche=" + nbPioche + "]";
	}

	
	@Override
	public void activer(Cible c) {
		this.joueur.piocher(this.nbPioche);
	}
	
	@Override
	public boolean isActivable(Cible c) {
		return true;
	}
	
	@Override
	public boolean isCiblable(){
		return false;
	}

}
