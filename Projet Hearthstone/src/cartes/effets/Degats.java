package cartes.effets;

import partie.autres.personnage.Personnage;

public class Degats extends Effet {
	/**
	 * Classe repr�sentant l'effet d�g�ts qui consiste � conna�tre le nombre de d�g�t que la cible va subir,
	 * elle poss�de un nombre de d�g�ts.
	 * H�rite d'effet.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 */

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
	public void activer(Personnage p) {
		p.prendreDegats(nbDegats);
	}
	@Override
	public boolean isActivable() {
		return true;
	}
	@Override
	public boolean isCiblable(){
		return true;
	}
}
