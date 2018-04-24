package partie.joueur.main;

import java.util.ArrayList;

import cartes.carte.Carte;

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
		
	public void jouerCarte(String nom){
		Carte c2;
		for(Carte c : getCartes()){
			if(c.getNom().equals(nom)){
				c2 = c;
				break;
			}
		}
		//il faut gerer le warning ici
		c2.jouerCarte();
	}

}
