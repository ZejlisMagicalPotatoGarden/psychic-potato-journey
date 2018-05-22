package cartes.sorts;

import cartes.carte.Carte;
import cartes.effets.Effet;
import partie.autres.cible.Cible;
import partie.joueur.plateau.Plateau;

public class Sort extends Carte {
	/**
	 * Classe représente un sort, un sort hérite de la classe carte et possède un effet, un nom
	 * une classe et un cout en mana. Il est utilisé par le joueur et peut être pioché, certains
	 * sorts sont propres à un héros.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see carte
	 * @see joueur
	 * @see effets
	 * @see sorts
	 */

	private String nom;
	private int cout;
	private String classe;
	private Effet effet;
	
	public Sort(String nom, int cout, Effet effet, String classe) {
		super(nom, cout, classe);
		setNom(nom);
		setCout(cout);
		setClasse(classe);
		setEffet(effet);
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
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
		Sort other = (Sort) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (cout != other.cout)
			return false;
		if (effet == null) {
			if (other.effet != null)
				return false;
		} else if (!effet.equals(other.effet))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sort [nom=" + nom + ", cout=" + cout + ", classe=" + classe + ", effet=" + effet + "]";
	}


	@Override
	public void jouerCarte(Plateau p) {
		if(this.effet.isCiblable()){
			//demander une cible
			Cible c = null;
			if(this.effet.isActivable(c))
				System.out.printf("Cible invalide pour le sort %s\n",this.nom);
			else
				this.effet.activer(c);
		}
		
	}
	@Override
	public boolean isJouable(Plateau p) {
		if(this.effet.isCiblable()){
			//demander une cible
			Cible c = null;
			if(this.effet.isActivable(c))
				return true;
			else
				return false;
		}
		else{
			if(this.effet.isActivable(null))
				return true;
			else
				return false;
		}
	}


}
