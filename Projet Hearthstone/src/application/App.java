package application;

import java.util.ArrayList;

import cartes.carte.Carte;
import cartes.serviteurs.Archimage;
import cartes.serviteurs.Busard_affame;
import cartes.serviteurs.Champion_de_Hurlevent;
import cartes.serviteurs.Chasse_maree_murloc;
import cartes.serviteurs.Chef_de_raid;
import cartes.serviteurs.Garde_de_baie_du_butin;
import cartes.serviteurs.Gnome_lepreux;
import cartes.serviteurs.Golem_des_moissons;
import cartes.serviteurs.L_ogre_magi;
import cartes.serviteurs.La_missiliere_temeraire;
import cartes.serviteurs.Serviteur;
import cartes.sorts.Attaque_mentale;
import cartes.sorts.Charge;
import cartes.sorts.Choc_de_flamme;
import cartes.sorts.Eclair_de_givre;
import cartes.sorts.Explosion_pyrotechnique;
import cartes.sorts.Image_mirroir;
import cartes.sorts.Intelligence_des_arcanes;
import cartes.sorts.Lachez_les_chiens;
import cartes.sorts.Marque_du_chasseur;
import cartes.sorts.Ordre_de_tuer;
import cartes.sorts.Tir_des_arcanes;
import console.Console;
import interfaceConsole.Interface;
import interfaceConsole.InterfaceAttaquer;
import interfaceConsole.InterfaceJouerCarte;
import interfaceConsole.InterfacePasserTour;
import interfaceConsole.InterfacePouvoirHeroique;
import interfaceGraphique.FenetrePrincipale;
import javafx.application.Application;
import javafx.stage.Stage;
import partie.joueur.deck.Deck;
import partie.joueur.heros.chasseur.Chasseur;
import partie.joueur.heros.heros.Heros;
import partie.joueur.heros.mage.Mage;
import partie.joueur.joueur.Joueur;
import partie.joueur.main.Main;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class App extends Application{
	
	public final static Console es = new Console();

	//------------A mettre dans Partie.java ?-----------------
	public static Partie initPartie() throws Exception{
		
		//Création de la partie
		Partie partie = new Partie(null, null);
		
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		Main main1 = new Main();
		Main main2 = new Main();
		Plateau plateau1 = new Plateau();
		Plateau plateau2 = new Plateau();
		Heros heros1 = new Mage();
		Heros heros2 = new Chasseur(partie);
		
		Joueur joueur1 = new Joueur(main1,deck1,plateau1,heros1);
		Joueur joueur2 = new Joueur(main2,deck2,plateau2,heros2);
		
		partie.setJoueur1(joueur1);
		partie.setJoueur2(joueur2);
		
		//Remplissage des decks et création des cartes
		deck1.addCarte(new Explosion_pyrotechnique());
		deck1.addCarte(new Intelligence_des_arcanes(partie));
		deck1.addCarte(new Choc_de_flamme(partie));
		deck1.addCarte(new Eclair_de_givre());
		deck1.addCarte(new Image_mirroir(partie));
		deck1.addCarte(new Golem_des_moissons(partie));
		deck1.addCarte(new Champion_de_Hurlevent());
		deck1.addCarte(new Archimage());
		deck1.addCarte(new Gnome_lepreux(partie));
		deck1.addCarte(new L_ogre_magi());
		deck1.addCarte(new La_missiliere_temeraire());
		deck1.addCarte(new Chasse_maree_murloc(partie));
		deck1.addCarte(new Chasse_maree_murloc(partie));
		deck1.addCarte(new Garde_de_baie_du_butin());
		deck1.addCarte(new Attaque_mentale(partie));
		
		deck2.addCarte(new Ordre_de_tuer());
		deck2.addCarte(new Lachez_les_chiens(partie));
		deck2.addCarte(new Tir_des_arcanes());
		deck2.addCarte(new Marque_du_chasseur());
		deck2.addCarte(new Busard_affame(partie));
		deck2.addCarte(new La_missiliere_temeraire());
		deck2.addCarte(new Garde_de_baie_du_butin());
		deck2.addCarte(new L_ogre_magi());
		deck2.addCarte(new Chef_de_raid());
		deck2.addCarte(new Charge());
		deck2.addCarte(new Gnome_lepreux(partie));
		deck2.addCarte(new Chasse_maree_murloc(partie));
		deck2.addCarte(new Champion_de_Hurlevent());
		deck2.addCarte(new Golem_des_moissons(partie));
		deck2.addCarte(new Chasse_maree_murloc(partie));
		
		deck1.melanger();
		deck2.melanger();
		
		partie.setTourJ1(true);
		try {
			joueur1.piocher(4);
			joueur2.piocher(5);
		} catch (Exception e) {
			e.getMessage();
		}
		
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
		Interface interfacePasserTour = new InterfacePasserTour(monInterface);
		Interface interfacePouvoirHeroique = new InterfacePouvoirHeroique(interfacePasserTour);
		Interface interfaceAttaquer = new InterfaceAttaquer(interfacePouvoirHeroique);
		Interface interfaceJouerCarte = new InterfaceJouerCarte(interfaceAttaquer);
		
		
		return interfaceJouerCarte;
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
		if(jAllie.getHeros().getPouvoir().isActivable())
			es.println(" et il est utilisable ce tour ci");
		else
			es.println(" et il n'est plus utilisable ce tour ci");
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
	
	@Override
	public void start(Stage s) throws Exception {
		try {
			new FenetrePrincipale(s, initPartie());
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Joueur jAllie, jEnnemi;
		String choix;
		
		Partie partie = initPartie();
		
		Interface ihm = initialiserInterfaces();
		
		if (ihm==null) {
			System.out.println("L'application ne sais rien faire....");
			System.exit(0);
		}	
		while(true){
			choix = "";
			jAllie = partie.getJoueurQuiJoue();
			if(jAllie.equals(partie.getJoueur1()))
				jEnnemi = partie.getJoueur2();
			else
				jEnnemi = partie.getJoueur1();
			
			try {
				jAllie.piocher(1);
			} catch (Exception e1) {
				e1.getMessage();
			}
			
			jAllie.setManaMax(jAllie.getManaMax() + 1);
			jAllie.setManaDispo(jAllie.getManaMax());
			for (Serviteur s : jAllie.getPlateau().getServiteurs()) {
				s.setNbAttaques(1);
			}
			for (Serviteur s : jEnnemi.getPlateau().getServiteurs()) {
				s.setNbAttaques(1);
			}
			jAllie.getHeros().getPouvoir().setNbUtilisations(1);
			jEnnemi.getHeros().getPouvoir().setNbUtilisations(1);
			
			/*while (!choix.equals(new InterfacePasserTour(null).getDescription())) {
				afficherTout(partie);
				
				choix = menu(ihm);
				try {
					ihm.interagir(choix, partie);
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			*/
			launch(args);
		}
	}
}