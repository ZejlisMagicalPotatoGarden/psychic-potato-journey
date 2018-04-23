package application;

import partie.joueur.deck.Deck;
import partie.joueur.heros.chasseur.Chasseur;
import partie.joueur.heros.heros.Heros;
import partie.joueur.heros.mage.Mage;
import partie.joueur.joueur.Joueur;
import partie.joueur.main.Main;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class App {

	//------------A mettre dans Partie.java ?-----------------
	public static Partie initPartie(){
		
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		Main main1 = new Main();
		Main main2 = new Main();
		Plateau plateau1 = new Plateau();
		Plateau plateau2 = new Plateau();
		Heros heros1 = new Chasseur();
		Heros heros2 = new Mage();
		
		Joueur joueur2 = new Joueur(main1,deck1,plateau1,heros1);
		Joueur joueur1 = new Joueur(main2,deck2,plateau2,heros2);
		Partie partie = new Partie(joueur1,joueur2);
		
		return partie;
	}
	
	public static void main(String[] args) {
		Partie partie = initPartie();
	}

}
