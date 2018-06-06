package interfaceGraphique;

import java.util.ArrayList;

import cartes.carte.Carte;
import cartes.effets.Effet;
import cartes.serviteurs.Serviteur;
import cartes.sorts.Sort;
import exceptions.HearthstoneException;
import interfaceConsole.Interface;
import interfaceConsole.InterfaceChoixEnnemiAttaque;
import interfaceConsole.InterfaceCiblage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import partie.autres.personnage.Personnage;
import partie.joueur.heros.pouvoir.Pouvoir;
import partie.joueur.joueur.Joueur;
import partie.joueur.main.Main;
import partie.partie.Partie;

public class FenetrePrincipale {
	
	private Stage stage;
	private Partie partie;
	private ArrayList<Button> main_alliee = new ArrayList<Button>();
	private ArrayList<Button> cartes_adverses = new ArrayList<Button>();
	private ArrayList<Button> cartes_alliees = new ArrayList<Button>();
	private VBox root;
	
	public FenetrePrincipale(Stage stage, Partie p){
		this.partie = p;
		this.stage = stage;
		
		Joueur jAllie, jEnnemi;
		
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
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		adversesButton();
		allieesButton();
		mainAllieeButton();
		
		buildPouvoirEnnemi();
		buildMainAdverse();
		buildCartesAdverses();
		buildBoutonFinTour();
		buildCartesAlliees();
		buildMainAlliee();
		buildPouvoirAllie();
		
		
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}

	public void viderBoutons(){
		main_alliee.clear();
		cartes_adverses.clear();
		cartes_alliees.clear();
	}
	
	public void afficherNormal(){
		stage.close();
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		viderBoutons();
		
		adversesButton();
		allieesButton();
		mainAllieeButton();
		
		buildPouvoirEnnemi();
		buildMainAdverse();
		buildCartesAdverses();
		buildBoutonFinTour();
		buildCartesAlliees();
		buildMainAlliee();
		buildPouvoirAllie();
		
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}
	
	public void afficherCible(Carte carte){
		stage.close();
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		viderBoutons();
		
		int i = 1;
		
		getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()+ "\t" + partie.getJoueurQuiJouePas().getHeros().getVie() + "pv"));
		getCartes_adverses().get(0).setOnAction(new EvtCiblee(carte.getEffet(), partie.getJoueurQuiJouePas().getHeros()));
		
		for(Serviteur c: partie.getJoueurQuiJouePas().getPlateau().getServiteurs()) {
			getCartes_adverses().add(new Button());
			getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_adverses().get(i).setOnAction(new EvtCiblee(carte.getEffet(), c));
			
			i++;
		}

		i = 1;
		
		getCartes_alliees().add(new Button(partie.getJoueurQuiJoue().getHeros().getNom()+ "\t" + partie.getJoueurQuiJoue().getHeros().getVie() + "pv"));
		getCartes_alliees().get(0).setOnAction(new EvtCiblee(carte.getEffet(), partie.getJoueurQuiJoue().getHeros()));
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_alliees().add(new Button());
			getCartes_alliees().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_alliees().get(i).setOnAction(new EvtCiblee(carte.getEffet(), c));

			i++;
		}
		
		i = 0;
		
		for(Carte c : partie.getJoueurQuiJoue().getMain().getCartes()) {
				getMain_alliee().add(new Button());

				getMain_alliee().get(i).setText(c+"");
				
				getMain_alliee().get(i).setOnAction(new EvtRetourMain(c));
				
				if(c != carte)
					getMain_alliee().get(i).setDisable(true);
				i++;
		}	
		
		buildPouvoirEnnemi();
		buildMainAdverse();
		buildCartesAdverses();
		
		HBox box = new HBox();
		
		Button finTour = new Button("Fin du tour");
		finTour.setOnAction(new EvtFinTour());
		finTour.setDisable(true);
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(finTour);
		
		getRoot().getChildren().add(box);
		
		buildCartesAlliees();
		buildMainAlliee();
		buildPouvoirAllie();
		
		
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}

	public void afficherAttaque(Serviteur attaquant){
		stage.close();
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		viderBoutons();
		
		int i = 1;
		
		if(partie.getJoueurQuiJouePas().getPlateau().getProvocs().isEmpty()){
			getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()+ "\t" + partie.getJoueurQuiJouePas().getHeros().getVie() + "pv"));
			getCartes_adverses().get(0).setOnAction(new EvtEtreAttaque(attaquant, partie.getJoueurQuiJouePas().getHeros()));
			for(Serviteur c: partie.getJoueurQuiJouePas().getPlateau().getServiteurs()) {
				getCartes_adverses().add(new Button());
				getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
						 +c.getAttaque()+ " Vie : "+c.getVie());
				getCartes_adverses().get(i).setOnAction(new EvtEtreAttaque(attaquant, c));
				
				i++;
			}
		}
		else
		{
			getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()+ "\t" + partie.getJoueurQuiJouePas().getHeros().getVie() + "pv"));
			getCartes_adverses().get(0).setOnAction(new EvtEtreAttaque(attaquant, partie.getJoueurQuiJouePas().getHeros()));
			getCartes_adverses().get(0).setDisable(true);
			for(Serviteur c: partie.getJoueurQuiJouePas().getPlateau().getServiteurs()) {
				getCartes_adverses().add(new Button());
				getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
						 +c.getAttaque()+ " Vie : "+c.getVie());
				getCartes_adverses().get(i).setOnAction(new EvtEtreAttaque(attaquant, c));
				if(!c.checkEffet("Provocation"))
					getCartes_adverses().get(i).setDisable(true);
				
				i++;
			}
		}

		i = 1;
		
		getCartes_alliees().add(new Button(partie.getJoueurQuiJoue().getHeros().getNom()+ "\t" + partie.getJoueurQuiJoue().getHeros().getVie() + "pv"));
		getCartes_alliees().get(0).setDisable(true);
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_alliees().add(new Button());
			getCartes_alliees().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			if(c != attaquant)
				getCartes_alliees().get(i).setDisable(true);
			else
				getCartes_alliees().get(i).setOnAction(new EvtRetour());
			
			i++;
		}
		
		i = 0;
		
		for(Carte c : partie.getJoueurQuiJoue().getMain().getCartes()) {
				getMain_alliee().add(new Button());

				getMain_alliee().get(i).setText(c+"");
				
				getMain_alliee().get(i).setOnAction(new EvtRetourMain(c));
				
				getMain_alliee().get(i).setDisable(true);
				
				i++;
		}	
		
		buildPouvoirEnnemi();
		buildMainAdverse();
		buildCartesAdverses();
		
		HBox box = new HBox();
		
		Button finTour = new Button("Fin du tour");
		finTour.setOnAction(new EvtFinTour());
		finTour.setDisable(true);
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(finTour);
		
		getRoot().getChildren().add(box);
		
		buildCartesAlliees();
		buildMainAlliee();
		
		HBox box2 = new HBox();
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJoue().getManaDispo()+" / "+partie.getJoueurQuiJoue().getManaMax() + "\t");
		Button pouvoir2 = new Button(partie.getJoueurQuiJoue().getHeros().getPouvoir().toString());
		
		pouvoir2.setOnAction(new EvtRetourPouvoir(partie.getJoueurQuiJoue().getHeros().getPouvoir()));
		pouvoir2.setDisable(true);
		
		box2.setAlignment(Pos.CENTER);
		
		box2.getChildren().add(mana);
		box2.getChildren().add(pouvoir2);
		
		
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}
	
	private void afficherCiblePouvoir(Pouvoir pouvoir) {
		stage.close();
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		viderBoutons();
		
		int i = 1;
		
		getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()+ "\t" + partie.getJoueurQuiJouePas().getHeros().getVie() + "pv"));
		getCartes_adverses().get(0).setOnAction(new EvtCiblee(pouvoir.getEffet(), partie.getJoueurQuiJouePas().getHeros()));
		
		for(Serviteur c: partie.getJoueurQuiJouePas().getPlateau().getServiteurs()) {
			getCartes_adverses().add(new Button());
			getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_adverses().get(i).setOnAction(new EvtCiblee(pouvoir.getEffet(), c));
			
			i++;
		}

		i = 1;
		
		getCartes_alliees().add(new Button(partie.getJoueurQuiJoue().getHeros().getNom()+ "\t" + partie.getJoueurQuiJoue().getHeros().getVie() + "pv"));
		getCartes_alliees().get(0).setOnAction(new EvtCiblee(pouvoir.getEffet(), partie.getJoueurQuiJoue().getHeros()));
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_alliees().add(new Button());
			getCartes_alliees().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_alliees().get(i).setOnAction(new EvtCiblee(pouvoir.getEffet(), c));

			i++;
		}
		
		i = 0;
		
		buildPouvoirEnnemi();
		buildMainAdverse();
		buildCartesAdverses();
		
		HBox box = new HBox();
		
		Button finTour = new Button("Fin du tour");
		finTour.setOnAction(new EvtFinTour());
		finTour.setDisable(true);
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(finTour);
		
		getRoot().getChildren().add(box);
		
		buildCartesAlliees();
		buildMainAlliee();
		
		HBox box2 = new HBox();
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJoue().getManaDispo()+" / "+partie.getJoueurQuiJoue().getManaMax() + "\t");
		Button pouvoir2 = new Button(partie.getJoueurQuiJoue().getHeros().getPouvoir().toString());
		
		pouvoir2.setOnAction(new EvtRetourPouvoir(partie.getJoueurQuiJoue().getHeros().getPouvoir()));
		
		box2.setAlignment(Pos.CENTER);
		
		box2.getChildren().add(mana);
		box2.getChildren().add(pouvoir2);
		
		getRoot().getChildren().add(box2);
		
		
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
		
	}
	
	private void initRoot() {
		root = new VBox();
		root.setPadding(new Insets(5,5,5,5));
		root.setSpacing(5);
	}

	private class EvtJouer implements EventHandler<ActionEvent>{
		/**Joue la carte sur laquelle l'utilisateur a cliqué*/
		private Carte c;
		
		public EvtJouer(Carte c){
			this.c = c;
		}
		
		@Override
		public void handle(ActionEvent event){
			try {
				Joueur jQuiJoue = partie.getJoueurQuiJoue();
				
				jQuiJoue.getMain().jouerCarte(c.getNom(), partie);
				jQuiJoue.setManaDispo(jQuiJoue.getManaDispo() - c.getCout());
				partie.checkMorts();
				
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(!c.getEffet().isCiblable())
				afficherNormal();
		}
		
	}
	
	private class EvtCiblee implements EventHandler<ActionEvent>{

		private Effet e;
		private Personnage cible;
		
		public EvtCiblee(Effet e, Personnage cible){
			this.e = e;
			this.cible = cible;
		}
		
		@Override
		public void handle(ActionEvent event) {
			try {
				e.activer(cible);
				partie.checkMorts();
			} catch (Exception e) {
				e.printStackTrace();
			}
			afficherNormal();
		}
	}
	
	
	private class EvtRetour implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			afficherNormal();
		}
	}
	
	private class EvtRetourMain implements EventHandler<ActionEvent>{

		private Carte c;
		
		public EvtRetourMain(Carte c){
			this.c = c;
		}
		
		@Override
		public void handle(ActionEvent event) {
			
			partie.getJoueurQuiJoue().getMain().addCarte(c);
			partie.getJoueurQuiJoue().setManaDispo(partie.getJoueurQuiJoue().getManaDispo() + c.getCout());
			afficherNormal();
		}
	}
	
	private class EvtRetourPouvoir implements EventHandler<ActionEvent>{

		private Pouvoir p;
		
		public EvtRetourPouvoir(Pouvoir p){
			this.p = p;
		}
		
		@Override
		public void handle(ActionEvent event) {
			
			partie.getJoueurQuiJoue().setManaDispo(partie.getJoueurQuiJoue().getManaDispo() + p.getCout());
			afficherNormal();
		}
	}
	
	private class EvtAttaquer implements EventHandler<ActionEvent>{

		private Serviteur attaquant;
		
		public EvtAttaquer(Serviteur attaquant){
			this.attaquant = attaquant;
		}
		
		@Override
		public void handle(ActionEvent event) {
			afficherAttaque(attaquant);
		}	
	}
	
	private class EvtEtreAttaque implements EventHandler<ActionEvent>{
		
		private Serviteur attaquant;
		private Personnage cible;
		
		public EvtEtreAttaque(Serviteur attaquant, Personnage cible){
			this.attaquant = attaquant;
			this.cible = cible;
		}
		
		@Override
		public void handle(ActionEvent event) {
			attaquant.attaquer(cible);
			try {
				partie.checkMorts();
			} catch (Exception e) {
				e.printStackTrace();
			}
			afficherNormal();
		}
	}
	
	private class EvtPouvoir implements EventHandler<ActionEvent>{
		
		private Joueur j;
		
		public EvtPouvoir(Joueur j){
			this.j = j;
		}
		
		@Override
		public void handle(ActionEvent event) {
			j.setManaDispo(j.getManaDispo() - j.getHeros().getPouvoir().getCout());
			if(j.getHeros().getPouvoir().isCiblable())
			{
				j.getHeros().getPouvoir().setNbUtilisations(j.getHeros().getPouvoir().getNbUtilisations() - 1);
				afficherCiblePouvoir(j.getHeros().getPouvoir());
			}
			else
			{
				try {
					j.getHeros().getPouvoir().activer(null);
					partie.checkMorts();
				} catch (Exception e) {
					e.getMessage();
				}

				afficherNormal();
			}
			
		}

	}
	
	private class EvtFinTour implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event) {
			
			partie.setTourJ1(!partie.isTourJ1());
			
			Joueur jAllie, jEnnemi;
			
			jAllie = partie.getJoueurQuiJoue();
			if(jAllie.equals(partie.getJoueur1()))
				jEnnemi = partie.getJoueur2();
			else
				jEnnemi = partie.getJoueur1();
			
			try {
				jAllie.piocher(1);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
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
			
			afficherNormal();
		}
	}
	
	
	public void mainAllieeButton() {
		/**Construit un tableau de boutons activable si la carte est jouable représentant la main du joueur*/
		int i = 0;
		
		for(Carte c : partie.getJoueurQuiJoue().getMain().getCartes()) {
				getMain_alliee().add(new Button());

				getMain_alliee().get(i).setText(c+"");
				
				getMain_alliee().get(i).setOnAction(new EvtJouer(c));
				
				if(!c.isJouable(partie.getJoueurQuiJoue().getPlateau()) || c.getCout() > partie.getJoueurQuiJoue().getManaDispo())
					getMain_alliee().get(i).setDisable(true);
				
				i++;
		}	
	}
	
	public void adversesButton() {
		/**Construit un tableau de boutons représentant les serviteurs adverses présent sur le plateau
		 * cette procédure a pour but de montrer les serviteurs pas de les attaquer*/
		int i = 1;
		
		getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()+ "\t" + partie.getJoueurQuiJouePas().getHeros().getVie() + "pv"));
		getCartes_adverses().get(0).setDisable(true);
		
		for(Serviteur c: partie.getJoueurQuiJouePas().getPlateau().getServiteurs()) {
			getCartes_adverses().add(new Button());
			getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_adverses().get(i).setDisable(true);
			i++;
		}
	}

	public void allieesButton() {
		/**Construit un tableau de bouton activables représentant les serviteurs alliés présent sur le plateau*/
		int i = 1;
		
		getCartes_alliees().add(new Button(partie.getJoueurQuiJoue().getHeros().getNom()+ "\t" + partie.getJoueurQuiJoue().getHeros().getVie() + "pv"));
		getCartes_alliees().get(0).setDisable(true);
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_alliees().add(new Button());
			getCartes_alliees().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ " Vie : "+c.getVie());
			getCartes_alliees().get(i).setOnAction(new EvtAttaquer(c));
			
			if(!c.isCapableAttaquer())
				getCartes_alliees().get(i).setDisable(true);

			i++;
		}
	}
	
	public void disableButtonAdverse() {
		for(Button c: getCartes_adverses()) 
			c.setDisable(true);
	}
	
	public void disableButtonAllies() {	
		for(Button c: getCartes_alliees())
			c.setDisable(true);
	}

	public void disableButtonMain() {		
		for(Button c: getMain_alliee()) 
			c.setDisable(true);
	}

	private void buildPouvoirEnnemi() {
		
		HBox box = new HBox();
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJouePas().getManaDispo()+" / "+partie.getJoueurQuiJouePas().getManaMax() + "\t");
		Button pouvoir = new Button(partie.getJoueurQuiJouePas().getHeros().getPouvoir().toString());
		
		pouvoir.setOnAction(new EvtPouvoir(partie.getJoueurQuiJouePas()));
		pouvoir.setDisable(true);
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(mana);
		box.getChildren().add(pouvoir);
		
		getRoot().getChildren().add(box);
	}
	
	private void buildPouvoirAllie() {
		
		HBox box = new HBox();
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJoue().getManaDispo()+" / "+partie.getJoueurQuiJoue().getManaMax() + "\t");
		Button pouvoir = new Button(partie.getJoueurQuiJoue().getHeros().getPouvoir().toString());
		
		pouvoir.setOnAction(new EvtPouvoir(partie.getJoueurQuiJoue()));
		if(!partie.getJoueurQuiJoue().getHeros().getPouvoir().isActivable() || partie.getJoueurQuiJoue().getHeros().getPouvoir().getCout() > partie.getJoueurQuiJoue().getManaDispo())
			pouvoir.setDisable(true);
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(mana);
		box.getChildren().add(pouvoir);
		
		getRoot().getChildren().add(box);
	}
	
	private void buildBoutonFinTour() {
		
		HBox box = new HBox();
		
		Button finTour = new Button("Fin du tour");
		finTour.setOnAction(new EvtFinTour());
		
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(finTour);
		
		getRoot().getChildren().add(box);
	}
	
	public void buildMainAlliee() {
		/**Place le tableau de bouton et la mana dispo dans un hbox placé en bas du la fenêtre*/
		
		HBox box = new HBox();
		
		box.setAlignment(Pos.CENTER);
		
		for(Button c: getMain_alliee())
			box.getChildren().add(c);
		
		getRoot().getChildren().add(box);
	}
	
	public void buildCartesAdverses() {
		/**Place les serviteurs adverses et le héros dans un hbox placé en haut de la fenêtre*/
		
		HBox adverse = new HBox();
		
		adverse.setAlignment(Pos.CENTER);
		
		for(Button c: getCartes_adverses())
			adverse.getChildren().add(c);
		
		getRoot().getChildren().add(adverse);
	}
	
	public void buildCartesAlliees() {
		/**Place les serviteurs alliés aux centre de la fenêtre*/
			
		HBox alliees = new HBox();
			
		alliees.setAlignment(Pos.CENTER);
		
		for(Button c: getCartes_alliees())
			alliees.getChildren().add(c);
			
		getRoot().getChildren().add(alliees);	
	}
	
	private void buildMainAdverse() {
		
		Label nbCartes = new Label("Votre adversaire a " + partie.getJoueurQuiJouePas().getMain().getCartes().size() + " cartes en main");
		
		HBox box = new HBox();
		
		box.setAlignment(Pos.CENTER);

		box.getChildren().add(nbCartes);
		
		getRoot().getChildren().add(box);	
	}
		
	public ArrayList<Button> getMain_alliee() {
		return main_alliee;
	}

	public void setMain_alliee(ArrayList<Button> main_alliee) {
		this.main_alliee = main_alliee;
	}

	public ArrayList<Button> getCartes_adverses() {
		return cartes_adverses;
	}

	public void setCartes_adverses(ArrayList<Button> cartes_adverses) {
		this.cartes_adverses = cartes_adverses;
	}

	public ArrayList<Button> getCartes_alliees() {
		return cartes_alliees;
	}

	public void setCartes_alliees(ArrayList<Button> cartes_alliees) {
		this.cartes_alliees = cartes_alliees;
	}

	public VBox getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

	public Stage getStage() {
		return stage;
	}
}
