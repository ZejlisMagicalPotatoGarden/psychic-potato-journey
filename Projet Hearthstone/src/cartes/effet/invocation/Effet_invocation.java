package cartes.effet.invocation;

import cartes.effet.effet.Effet;
import cartes.serviteur.Serviteur;
import partie.autres.cible.Cible;
import partie.joueur.plateau.Plateau;

public class Effet_invocation extends Effet {

	private Plateau plateau;
	private Serviteur serviteur;
	private String description;
	private String nom;
	private String type;
	private boolean ciblable;
	
	
	public Effet_invocation(String description, String nom, String type, Plateau plateau,
			Serviteur serviteur) {
		super(description, nom, type, false);
		this.plateau = plateau;
		this.serviteur = serviteur;
		this.description = description;
		this.nom = nom;
		this.type = type;
		this.ciblable = true;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}
	public void setJoueur(Plateau plateau) {
		this.plateau = plateau;
	}
	public Serviteur getServiteur() {
		return serviteur;
	}
	public void setServiteur(Serviteur serviteur) {
		this.serviteur = serviteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	

	
	@Override
	public void activer(Cible c) {
		this.serviteur.invoquer();
	}

	@Override
	public boolean isActivable(Cible c) {
		return !(plateau.isPlein());
	}

}
