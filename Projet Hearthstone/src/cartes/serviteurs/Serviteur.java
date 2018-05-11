package cartes.serviteurs;

import cartes.carte.Carte;
import cartes.effets.Effet;
import partie.autres.cible.Cible;
import partie.autres.personnage.Personnage;
import partie.joueur.joueur.Joueur;
import partie.joueur.plateau.Plateau;

public class Serviteur extends Carte implements Personnage {
	
	private int vieMax;
	private int vie;
	private int attaque;
	private Effet effet;
	

	public Serviteur(String nom, int cout, String classe, int vieMax, int attaque,
			Effet effet) {
		super(nom, cout, classe);
		this.vieMax = vieMax;
		this.vie = vieMax;
		this.attaque = attaque;
		this.effet = effet;
	}

	
	public int getVieMax() {
		return vieMax;
	}
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
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
		Serviteur other = (Serviteur) obj;
		if (attaque != other.attaque)
			return false;
		if (effet == null) {
			if (other.effet != null)
				return false;
		} else if (!effet.equals(other.effet))
			return false;
		if (vie != other.vie)
			return false;
		if (vieMax != other.vieMax)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Serviteur [vieMax=" + vieMax + ", vie=" + vie + ", attaque=" + attaque + ", effet=" + effet + "]";
	}


	@Override
	public void prendreDegats(int x) {
		this.vie = this.vie - x;
		System.out.printf("%s prend %d point(s) de dégats\n",super.getNom(),x);
	}

	@Override
	public void mourir(Joueur j) {
		System.out.printf("%s est mort",super.getNom());
		if(checkEffet("Mort") && this.effet.isActivable(null)){
			//Un effet de mort ne demande jamais a l'utilisateur une cible
			this.effet.activer(null);
		}
		j.getPlateau().removeServiteur(this);
	}

	@Override
	public void jouerCarte(Plateau p) {
		if(checkEffet("Entrée")){
			if(this.effet.isCiblable()){
				//Demander une cible
				Cible c = null;
				if(this.effet.isActivable(c))
					this.effet.activer(c);
			}
			else
				this.effet.activer(null);
		}
		invoquer(p);
	}
	
	public void invoquer(Plateau p){
		p.addServiteur(this);
	}
	
	public void attaquer(Cible cible) {
		cible.prendreDegats(this.attaque);
		prendreDegats(cible.getAttaque());
	}

	@Override
	public void augmenterAttaque(int bonusAttaque) {
		this.attaque = this.attaque + bonusAttaque;
	}
	
	@Override
	public void augmenterVie(int bonusVie) {
		this.vie = this.vie + bonusVie;
		this.vieMax = this.vieMax + bonusVie;
	}
	
	public boolean checkEffet(String type){
		return this.effet.getType().contains(type);
	}


	@Override
	public boolean isJouable(Plateau p) {
		if (p.isPlein())
			return false;
		if(checkEffet("Entrée")){
			return(this.effet.isActivable(null));
		}
		return true;
	}

	public boolean isMort(){
		return(this.vie <= 0);
	}
}
