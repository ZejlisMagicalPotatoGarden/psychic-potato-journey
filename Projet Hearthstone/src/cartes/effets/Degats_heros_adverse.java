package cartes.effets;

import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class Degats_heros_adverse extends Degats {

	private Partie partie;
	
	public Degats_heros_adverse(String description, String nom, String type, int nbDegats, Partie partie) {
		super(description, nom, type, nbDegats);
		this.partie = partie;
	}

	
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Degats_heros_adverse other = (Degats_heros_adverse) obj;
		if (partie == null) {
			if (other.partie != null)
				return false;
		} else if (!partie.equals(other.partie))
			return false;
		return true;
	}

	@Override
	public boolean isCiblable() {
		return false;
	}

	@Override
	public void activer(Personnage p) {
		partie.getJoueurQuiJouePas().getHeros().prendreDegats(getNbDegats());
	}
}
