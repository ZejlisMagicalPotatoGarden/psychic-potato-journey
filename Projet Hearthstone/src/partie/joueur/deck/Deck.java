package partie.joueur.deck;

import java.util.ArrayList;

import cartes.carte.Carte;
import partie.joueur.main.Main;

public class Deck {

	private ArrayList<Carte> cartes;

	public Deck() {
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
		Deck other = (Deck) obj;
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
	
	public void piocher(int nbPioche, Main m){
		for(int i=0;i<nbPioche;i++){
			Carte c = getCartes().get(0);
			m.addCarte(c);
			removeCarte(c);
		}
	}
	
}
