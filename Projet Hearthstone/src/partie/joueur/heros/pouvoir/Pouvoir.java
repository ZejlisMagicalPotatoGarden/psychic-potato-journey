package partie.joueur.heros.pouvoir;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;

public abstract class Pouvoir extends Effet {

	private int nbUtilisations;
	private String description;
	private String nom;
	private String type;
	
	public Pouvoir(Effet effet) {
		super(effet.getDescription(), effet.getNom(), effet.getType());
		this.nbUtilisations = 1;
		this.description = effet.getDescription();
		this.type = effet.getType();
		this.nom = effet.getNom();
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nbUtilisations != other.nbUtilisations)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pouvoir [nbUtilisations=" + nbUtilisations + ", description=" + description + ", nom=" + nom + ", type="
				+ type + "]";
	}

	@Override
	public abstract void activer(Cible c);

	@Override
	public boolean isActivable(Cible c){
		return(this.nbUtilisations > 0);
	}
}
