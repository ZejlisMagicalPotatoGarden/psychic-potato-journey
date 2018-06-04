package partie.joueur.heros.pouvoir;

import cartes.effets.Effet;
import partie.autres.personnage.Personnage;

public class Pouvoir extends Effet {
	/**
	 * Classe représentant un pouvoir, les classes du pouvoir du mage et du chasseur hériteront de cette classe.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 */

	private int nbUtilisations;
	private Effet effet;
	private int cout;
	
	public Pouvoir(Effet effet, int cout) {
		super(effet.getDescription(), effet.getNom(), effet.getType());
		setNbUtilisations(1);
		setEffet(effet);
		setCout(cout);
	}

	
	public int getNbUtilisations() {
		return nbUtilisations;
	}
	public void setNbUtilisations(int nbUtilisations) {
		this.nbUtilisations = nbUtilisations;
	}
	public Effet getEffet() {
		return effet;
	}
	public void setEffet(Effet effet) {
		this.effet = effet;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}


	@Override
	public void activer(Personnage p) throws Exception {
		this.effet.activer(p);
		setNbUtilisations(getNbUtilisations() - 1);
	}
	@Override
	public boolean isActivable() {
		return (this.nbUtilisations > 0 && this.effet.isActivable());
	}
	@Override
	public boolean isCiblable() {
		return this.effet.isCiblable();
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pouvoir other = (Pouvoir) obj;
		if (cout != other.cout)
			return false;
		if (effet == null) {
			if (other.effet != null)
				return false;
		} else if (!effet.equals(other.effet))
			return false;
		if (nbUtilisations != other.nbUtilisations)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return effet.toString();
	}
	
}
