package cartes.effets;

import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class Pioche extends Effet {

	private int nbPioche;
	private Partie partie;
	
	public Pioche(String description, String nom, String type, int nbPioche) {
		super(description, nom, type);
		setNbPioche(nbPioche);
		setPartie(null);
	}
	
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
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
	public void activer(Personnage p) {
		partie.getJoueurQuiJoue().piocher(getNbPioche());
	}
	
	@Override
	public boolean isActivable() {
		return true;
	}
	
	@Override
	public boolean isCiblable(){
		return false;
	}
}
