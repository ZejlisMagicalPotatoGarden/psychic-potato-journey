package cartes.effets;

import partie.autres.cible.Cible;
import partie.autres.personnage.Personnage;

public class Degats extends Effet {

	private int nbDegats;
	
	
	public Degats(String description, String nom, String type, int nbDegats) {
		super(description, nom, type);
		setNbDegats(nbDegats);
	}
	
	public int getNbDegats() {
		return nbDegats;
	}
	public void setNbDegats(int nbDegats) {
		this.nbDegats = nbDegats;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Degats other = (Degats) obj;
		if (nbDegats != other.nbDegats)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Effet_degats [nbDegats=" + nbDegats + "]";
	}

	
	@Override
	public void activer(Cible c) {
		for(Personnage s : c.getCibles()){
			s.prendreDegats(nbDegats);
		}
	}
	@Override
	public boolean isActivable(Cible c) {
		return !(c == null);
	}
	@Override
	public boolean isCiblable(){
		return true;
	}
}
