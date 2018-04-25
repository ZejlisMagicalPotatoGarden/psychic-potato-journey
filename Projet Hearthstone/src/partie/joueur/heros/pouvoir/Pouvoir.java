package partie.joueur.heros.pouvoir;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;

public class Pouvoir extends Effet {

	private int nbUtilisations;
	private Effet effet;
	
	public Pouvoir(Effet effet) {
		super(effet.getDescription(), effet.getNom(), effet.getType());
		this.nbUtilisations = 1;
		this.effet = effet;
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
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pouvoir other = (Pouvoir) obj;
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
		return "Pouvoir [nbUtilisations=" + nbUtilisations + ", effet=" + effet + "]";
	}


	@Override
	public void activer(Cible c) {
		this.effet.activer(c);
		this.nbUtilisations = this.nbUtilisations - 1;
	}
	@Override
	public boolean isActivable(Cible c) {
		return (this.nbUtilisations > 0 && this.effet.isActivable(c));
	}
	@Override
	public boolean isCiblable() {
		return this.effet.isCiblable();
	}


	
}
