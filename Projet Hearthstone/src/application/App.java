package application;

import java.util.ArrayList;

import cartes.carte.Carte;
import cartes.serviteur.Serviteur;
import cartes.serviteurs.Serviteur_modele;
import cartes.sorts.Sort_modele;
import console.Console;
import interfaceConsole.Interface;
import interfaceConsole.InterfaceAttaquer;
import interfaceConsole.InterfaceJouerCarte;
import interfaceConsole.InterfacePasserTour;
import partie.joueur.deck.Deck;
import partie.joueur.heros.chasseur.Chasseur;
import partie.joueur.heros.heros.Heros;
import partie.joueur.heros.mage.Mage;
import partie.joueur.joueur.Joueur;
import partie.joueur.main.Main;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class App {
	
	public final static Console es = new Console();

	//------------A mettre dans Partie.java ?-----------------
	public static Partie initPartie(){
		
		Carte carte1 = new Serviteur_modele();
		Carte carte2 = new Serviteur_modele();
		Carte carte3 = new Serviteur_modele();
		Carte carte4 = new Serviteur_modele();
		Carte carte5 = new Sort_modele();
		
		Carte carte6 = new Serviteur_modele();
		Carte carte7 = new Serviteur_modele();
		Carte carte8 = new Serviteur_modele();
		Carte carte9 = new Serviteur_modele();
		Carte carte10 = new Sort_modele();
		
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
		deck1.addCarte(carte6);
		deck1.addCarte(carte7);
		deck1.addCarte(carte8);
		deck1.addCarte(carte9);
		deck1.addCarte(carte10);
		
		deck2.addCarte(carte1);
		deck2.addCarte(carte2);
		deck2.addCarte(carte3);
		deck2.addCarte(carte4);
		deck2.addCarte(carte5);
		deck2.addCarte(carte6);
		deck2.addCarte(carte7);
		deck2.addCarte(carte8);
		deck2.addCarte(carte9);
		deck2.addCarte(carte10);
		
		Joueur joueur2 = new Joueur(main1,deck1,plateau1,heros1);
		Joueur joueur1 = new Joueur(main2,deck2,plateau2,heros2);
		Partie partie = new Partie(joueur1,joueur2);
		
		partie.setTourJ1(true);
		joueur1.piocher(4);
		joueur2.piocher(5);
		//joueur2.getMain().addCarte(new Piece());
		
		return partie;
	}
	
	private static String menu(Interface ihm) {
		ArrayList<String>	menu = new ArrayList<String>();
		Interface i = ihm;
		while (i != null) {
			menu.add(i.getDescription());
			i = i.getSuivant();
		}
		
		int n = 1;
		for (String s : menu) {
			es.println(""+n+". "+s);
			n++;
		}
		
		es.println("");
		es.println("Votre choix : ");
		int choix = es.readInt();
		
		return menu.get(choix-1);
	}

	private static Interface initialiserInterfaces() {
		Interface monInterface = null;
		Interface interfaceJouerCarte = new InterfaceJouerCarte(monInterface);
		Interface interfacePasserTour = new InterfacePasserTour(interfaceJouerCarte);
		Interface interfaceAttaquer = new InterfaceAttaquer(interfacePasserTour);
		
		return interfaceAttaquer;
	}
	
	public static void afficherTout(Partie p){
		
		//----------------A mettre dans les toString---------------
		Joueur jAllie = p.getJoueurQuiJoue();
		Joueur jEnnemi;
		if(jAllie.equals(p.getJoueur1()))
			jEnnemi = p.getJoueur2();
		else
			jEnnemi = p.getJoueur1();
		
		System.out.printf("Vous ètes %s, il vous reste %d points de vie \n",
				jAllie.getHeros().getNom(),jAllie.getHeros().getVie());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Votre pouvoir est %s, %s, il coute %d mana",
				jAllie.getHeros().getPouvoir().getNom(),jAllie.getHeros().getPouvoir().getDescription(),
				jAllie.getHeros().getPouvoir().getCout());
		if(jAllie.getHeros().getPouvoir().getNbUtilisations() == 0)
			es.println(" et il n'est plus utilisable ce tour ci");
		else
			es.println(" et il est utilisable ce tour ci");
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Vous avez %d carte(s) dans votre deck\n",
				jAllie.getDeck().getCartes().size());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Vous avez %d carte(s) en main\n",
				jAllie.getMain().getCartes().size());
		for (Carte c : jAllie.getMain().getCartes()) {
			System.out.printf("%s, cout : %d mana\n",
					c.getNom(),c.getCout());
		}
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Vous avez %d serviteur(s) sur votre plateau\n",
				jAllie.getPlateau().getServiteurs().size());
		for (Serviteur s : jAllie.getPlateau().getServiteurs()) {
			System.out.printf("%s, %d d'attaque, %d point(s) de vie\n",
					s.getNom(),s.getAttaque(),s.getVie());
		}
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Vous avez %d mana sur %d\n",
				jAllie.getManaDispo(),jAllie.getManaMax());
		
		es.println("-------------------------------------------------------------------------------");
		es.println("-------------------------------------------------------------------------------");
		es.println("-------------------------------------------------------------------------------");
		
		System.out.printf("Votre adversaire est %s, il lui reste %d points de vie \n",
				jEnnemi.getHeros().getNom(),jEnnemi.getHeros().getVie());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Son pouvoir est %s, %s, il coute %d mana\n",
				jEnnemi.getHeros().getPouvoir().getNom(),jEnnemi.getHeros().getPouvoir().getDescription(),
				jEnnemi.getHeros().getPouvoir().getCout());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Il a %d carte(s) dans son deck\n",
				jEnnemi.getDeck().getCartes().size());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Il a %d carte(s) en main\n",
				jEnnemi.getMain().getCartes().size());
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Il a %d serviteur(s) sur son plateau\n",
				jEnnemi.getPlateau().getServiteurs().size());
		for (Serviteur s : jEnnemi.getPlateau().getServiteurs()) {
			System.out.printf("%s, %d d'attaque, %d point(s) de vie\n",
					s.getNom(),s.getAttaque(),s.getVie());
		}
		es.println("-------------------------------------------------------------------------------");
		System.out.printf("Il a %d mana\n",
				jEnnemi.getManaMax());
	}
	
	public static void main(String[] args) {
		
		Joueur jAllie, jEnnemi;
		boolean finDeTour = false;
		String choix;
		
		Partie partie = initPartie();
		
		//
		Interface ihm = initialiserInterfaces();
		
		if (ihm==null) {
			System.out.println("L'application ne sais rien faire....");
			System.exit(0);
		}	
		
		while (!finDeTour) {
			choix = menu(ihm);
			try {
				ihm.interagir(choix, partie, finDeTour);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		while(true){
			finDeTour = false;
			jAllie = partie.getJoueurQuiJoue();
			if(jAllie.equals(partie.getJoueur1()))
				jEnnemi = partie.getJoueur2();
			else
				jEnnemi = partie.getJoueur1();
			jAllie.piocher(1);
			jAllie.setManaMax(jAllie.getManaMax() + 1);
			jAllie.setManaDispo(jAllie.getManaMax());
			
			
			//-------------Chaine de responsabilité------------
			while(!finDeTour)
			{
				afficherTout(partie);
				switch(jAllie.action()){
					case "Attaquer":
						es.println("Avec quel serviteur ?");
						for (Serviteur s : jAllie.getPlateau().getServiteurs()) {
							System.out.printf("%s, %d d'attaque, %d point(s) de vie\n",
									s.getNom(),s.getAttaque(),s.getVie());
						}
						choix = es.readLine();//récupérer attaquant
						es.println("Quel adversaire voulez vous attaquer ?");
						System.out.printf("%s, %d points de vie \n",
								jEnnemi.getHeros().getNom(),jEnnemi.getHeros().getVie());
						for (Serviteur s : jEnnemi.getPlateau().getServiteurs()) {
							System.out.printf("%s, %d d'attaque, %d point(s) de vie\n",
									s.getNom(),s.getAttaque(),s.getVie());
						}
						choix = es.readLine();//récupérer cible de l'attaque
						//Attaquer
					case "Passer":
						finDeTour = true;
					case "Jouer":
						es.println("Quelle carte ?");
						for (Carte c : jAllie.getMain().getCartes()) {
							if(c.isJouable(jAllie.getPlateau())){
								System.out.printf("%s, cout : %d mana\n",
										c.getNom(),c.getCout());
							}
						}
						System.out.printf("Vous avez %d mana sur %d\n",
								jAllie.getManaDispo(),jAllie.getManaMax());
						choix = es.readLine();
						
						jAllie.getMain().jouerCarte(choix, jAllie.getPlateau());
						jAllie.setManaDispo(jAllie.getManaDispo() - jAllie.getMain().getCarte(choix).getCout());
				}
			}
			partie.setTourJ1(!partie.isTourJ1());
			
		}
		*/
	}

}
