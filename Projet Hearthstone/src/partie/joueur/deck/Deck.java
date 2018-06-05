package partie.joueur.deck;

import java.util.ArrayList;
import java.util.Random;

import cartes.carte.Carte;
import exceptions.HearthstoneException;
import partie.joueur.main.Main;

public class Deck {
	/**
	 * Classe représentant un deck, un deck est un tableau de Carte.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Deck
	 */

	public final static int NB_MAX_CARTES_DECK = 15;
	
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
	
	public void piocher(int nbPioche, Main m) throws Exception{
		if(getCartes().size() <= 0)
			throw new HearthstoneException("Le deck est vide");
		
		for(int i=0;i<nbPioche;i++){
			if(getCartes().size() <= 0)
				throw new HearthstoneException("Le deck est vide");
			if(m.getCartes().size() == Main.NB_MAX_CARTES_MAIN){
				Carte c = getCartes().get(0);
				removeCarte(c);
				throw new HearthstoneException("Vous avez trop de cartes en main !");
			}
			Carte c = getCartes().get(0);
			m.addCarte(c);
			removeCarte(c);
		}
	}
	
	public void melanger(){
		Random random = new Random();
		Deck deckMelange = new Deck();
		int rand, i = 1;

		while(i < NB_MAX_CARTES_DECK){
			rand = random.nextInt(NB_MAX_CARTES_DECK - i);
			deckMelange.addCarte(this.cartes.get(rand));
			cartes.remove(rand);
			i++;
		}
		deckMelange.addCarte(this.cartes.get(0));
		setCartes(deckMelange.cartes);
	}
}
