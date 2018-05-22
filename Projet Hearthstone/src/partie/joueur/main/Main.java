package partie.joueur.main;

import java.util.ArrayList;

import cartes.carte.Carte;
import partie.joueur.plateau.Plateau;

public class Main {
	
	private ArrayList<Carte> cartes;

	
	public Main() {
		this.cartes = new ArrayList<Carte>();
	}
		
	
	public ArrayList<Carte> getCartes() {
		return cartes;
	}
	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}
	
	
	@Override
	public String toString() {
		return "Deck [cartes=" + cartes + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Main other = (Main) obj;
		if (cartes == null) {
			if (other.cartes != null)
				return false;
		} else if (!cartes.equals(other.cartes))
			return false;
		return true;
	}
		
	public void addCarte(Carte c){
		this.cartes.add(c);
	}
	public void removeCarte(Carte c){
		this.cartes.remove(this.cartes.indexOf(c));
	}
	public Carte getCarte(String nom){
		Carte carte = null;
		for(Carte c : getCartes()){
			if(c.getNom().equals(nom)){
				carte = c;
				break;
			}
		}
		return carte;
	}
	public void jouerCarte(String nom, Plateau p){
		Carte carte = getCarte(nom);
		if(carte == null){
			System.out.printf("%s n'est pas dans cette main\n",nom);
			//Erreur, faire une exception
		}
		if(carte.isJouable(p)){
			try {
				carte.jouerCarte(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.removeCarte(carte);
		}
		else
			//La aussi mettre une exception
			System.out.printf("%s n'est pas jouable",carte);
	}

}
