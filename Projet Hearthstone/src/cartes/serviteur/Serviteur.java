package cartes.serviteur;

import cartes.carte.Carte;
import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;
import partie.autres.personnage.Personnage;
import partie.joueur.plateau.Plateau;

public class Serviteur extends Carte implements Personnage {

	private String nom;
	private int cout;
	private String classe;
	
	private int vieMax;
	private int vie;
	private int attaque;
	private Effet effet;
	private Plateau plateau;
	

	public Serviteur(String nom, int cout, String classe, int vieMax, int attaque,
			Effet effet, Plateau plateau) {
		super(nom, cout, classe);
		this.nom = nom;
		this.cout = cout;
		this.classe = classe;
		this.vieMax = vieMax;
		this.vie = vieMax;
		this.attaque = attaque;
		this.effet = effet;
		this.plateau = plateau;
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
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public void prendreDegats(int x) {
		this.vie = this.vie - x;
		System.out.printf("%s prend %d point(s) de dégats\n",this.nom,x);
		if(this.vie <= 0)
			mourir();
	}

	@Override
	public void mourir() {
		System.out.printf("%s est mort",this.nom);
		if(checkEffet("Mort") && this.effet.isActivable(null)){
			//Un effet de mort ne demande jamais a l'utilisateur une cible
			this.effet.activer(null);
		}
		this.plateau.removeServiteur(this);
	}

	@Override
	public void jouerCarte() {
		if(checkEffet("Entrée") && this.effet.isActivable(null)){
			//Un effet de mort ne demande jamais a l'utilisateur une cible
			this.effet.activer(null);
		}
	}
	
	public void invoquer(){
		this.plateau.addServiteur(this);
	}
	
	public void attaquer(Cible cible) {
		// TODO Auto-generated method stub
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

}
