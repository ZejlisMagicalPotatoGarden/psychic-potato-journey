package cartes.serviteurs;

import cartes.carte.Carte;
import cartes.effets.Effet;
import interfaceConsole.Interface;
import interfaceConsole.InterfaceCiblage;
import partie.autres.personnage.Personnage;
import partie.joueur.joueur.Joueur;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Serviteur extends Carte implements Personnage {
	/**
	 * Classe représentant un serviteur, un serviteur hérite de la classe Carte et possède un effet,
	 * il est utilisé par le joueur et peut être pioché. Il possède une vie max et une vie courante
	 * ainsi qu'une attaque.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 * @see Joueur
	 * @see Carte
	 * @see Personnage
	 */
	
	private int vieMax;
	private int vie;
	private int attaque;
	private int nbAttaques;
	private Effet effet;
	

	public Serviteur(String nom, int cout, String classe, int vieMax, int attaque,
			Effet effet) {
		super(nom, cout, classe);
		setVieMax(vieMax);
		setVie(vieMax);
		setAttaque(attaque);
		setEffet(effet);
		if(checkEffet("Charge"))
			setNbAttaques(1);
		else
			setNbAttaques(0);
	}
	
	public Serviteur(Serviteur s)
	{
		super(s.getNom(),s.getCout(),s.getClasse());
		setVieMax(s.getVieMax());
		setVie(s.getVieMax());
		setAttaque(s.getAttaque());
		setEffet(s.getEffet());
		setNbAttaques(s.getNbAttaques());
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
	public int getNbAttaques() {
		return nbAttaques;
	}
	public void setNbAttaques(int nbAttaques) {
		this.nbAttaques = nbAttaques;
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
		if (nbAttaques != other.nbAttaques)
			return false;
		if (vie != other.vie)
			return false;
		if (vieMax != other.vieMax)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Serviteur " + getNom() + " cout=" + getCout() + " vie=" + vie + ", attaque=" + attaque + ", " + effet;
	}


	@Override
	public void prendreDegats(int x) {
		this.vie = this.vie - x;
		System.out.printf("%s prend %d point(s) de dégats\n",super.getNom(),x);	
	}

	@Override
	public void mourir(Joueur j) throws Exception {
		System.out.printf("%s est mort\n",super.getNom());
		if(checkEffet("Mort")){
			//Un effet de mort ne demande jamais a l'utilisateur une cible
			this.effet.activer(null);
		}
		else if(checkEffet("Aura"))
		{
			this.effet.activer(null);
			for(Serviteur s : j.getPlateau().getServiteurs())
				this.effet.activer(s);
		}
		j.getPlateau().removeServiteur(this);
	}

	@Override
	public void jouerCarte(Partie p) throws Exception {
		if(checkEffet("Entrée")){
			if(this.effet.isCiblable()){
				if(this.effet.isActivable())
				{
					Interface ihm = new InterfaceCiblage(null,this.getEffet());
					ihm.interagir("Choisir un personnage à cibler pour "+effet, p);
				}
			}
			else
				this.effet.activer(null);
		}
		else if(checkEffet("Aura"))
		{
			for(Serviteur s : p.getJoueurQuiJoue().getPlateau().getServiteurs())
				this.effet.activer(s);
		}
		invoquer(p.getJoueurQuiJoue().getPlateau());
	}
	
	public void invoquer(Plateau p) throws Exception{
		for(Serviteur s : p.getServiteurs())
		{
			if(s.checkEffet("Aura"))
				s.getEffet().activer(this);
		}
		p.addServiteur(this);
	}
	
	public void attaquer(Personnage cible) {
		cible.prendreDegats(this.attaque);
		this.prendreDegats(cible.getAttaque());
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
		if(this.effet != null)
			return this.effet.getType().equals(type);
		else
			return false;
	}


	@Override
	public boolean isJouable(Plateau p) {
		if (p.isPlein())
			return false;
		if(checkEffet("Entrée")){
			return(this.effet.isActivable());
		}
		return true;
	}

	public boolean isMort(){
		return(this.vie <= 0);
	}
	
	public boolean isCapableAttaquer(){
		return (getNbAttaques() > 0 && getAttaque() > 0);
	}
}
