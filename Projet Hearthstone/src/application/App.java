package application;

import cartes.carte.Carte;
import cartes.serviteurs.Serviteur_modele;
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
		
		Carte carte1 = new Serviteur_modele();
		Carte carte2 = new Serviteur_modele();
		Carte carte3 = new Serviteur_modele();
		Carte carte4 = new Serviteur_modele();
		Carte carte5 = new Serviteur_modele();
		Carte carte6 = new Serviteur_modele();
		Carte carte7 = new Serviteur_modele();
		Carte carte8 = new Serviteur_modele();
		Carte carte9 = new Serviteur_modele();
		Carte carte10 = new Serviteur_modele();
		
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		Main main1 = new Main();
		Main main2 = new Main();
		Plateau plateau1 = new Plateau();
		Plateau plateau2 = new Plateau();
		Heros heros1 = new Chasseur();
		Heros heros2 = new Mage();

		deck1.addCarte(carte1);
		deck1.addCarte(carte2);
		deck1.addCarte(carte3);
		deck1.addCarte(carte4);
		deck1.addCarte(carte5);
		
		deck2.addCarte(carte6);
		deck2.addCarte(carte7);
		deck2.addCarte(carte8);
		deck2.addCarte(carte9);
		deck2.addCarte(carte10);
		
		Joueur joueur2 = new Joueur(main1,deck1,plateau1,heros1);
		Joueur joueur1 = new Joueur(main2,deck2,plateau2,heros2);
		Partie partie = new Partie(joueur1,joueur2);
		
		
		return partie;
	}
	
	public static void main(String[] args) {
		Partie partie = initPartie();
	}

}
