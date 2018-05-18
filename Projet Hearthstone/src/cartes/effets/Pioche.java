package cartes.effets;

import partie.autres.cible.Cible;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class Pioche extends Effet {

	private int nbPioche;
	
	public Pioche(String description, String nom, String type, int nbPioche) {
		super(description, nom, type);
		setNbPioche(nbPioche);
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
		if (nbPioche != other.nbPioche)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Effet_pioche [nbPioche=" + nbPioche + "]";
	}

	
	@Override
	public void activer(Cible c) {
		
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
