package partie.joueur.main;

import java.util.ArrayList;

import cartes.carte.Carte;
import exceptions.HearthstoneException;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Main {
	
	public final static int NB_MAX_CARTES_MAIN = 10;
	
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
			}
		}
		return carte;
	}
	
	public void jouerCarte(String nom, Partie p) throws Exception{
		Carte carte = getCarte(nom);
		if(carte == null){
			throw new HearthstoneException("Cette carte n'est pas dans cette main");
		}
		if(carte.isJouable(p.getJoueurQuiJoue().getPlateau())){
			try {
				carte.jouerCarte(p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.removeCarte(carte);
		}
		else
			throw new HearthstoneException("Cette carte n'est pas jouable");
	}

}
