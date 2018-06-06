package interfaceGraphique;

import java.util.ArrayList;

import cartes.carte.Carte;
import cartes.serviteurs.Serviteur;
import cartes.sorts.Sort;
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
	
	public FenetrePrincipale(Stage s, Partie p){
		this.partie = p;
		this.stage = s;
		
		initRoot();
		
		Scene scene = new Scene(root,400,200);
		stage.setTitle("Hearthstone");
		
		adversesButton();
		allieesButton();
		mainAllieeButton();
		
		buildMainAdverse();
		buildCartesAdverses();
		buildBoutonFinTour();
		buildCartesAlliees();
		buildMainAlliee();
		
		
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
		
		buildMainAdverse();
		buildCartesAdverses();
		buildBoutonFinTour();
		buildCartesAlliees();
		buildMainAlliee();
		
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
		public void handle(ActionEvent event) {
			try {
				c.jouerCarte(partie);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	private class EvtAttaquer implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
		}	
	}
	
	private class EvtEtreAttaque implements EventHandler<ActionEvent>{
		
		Serviteur attaquant;
		
		public EvtEtreAttaque(Serviteur s){
			this.attaquant = s;
		}
		
		@Override
		public void handle(ActionEvent event) {
			
		}
	}
	
	private class EvtFinTour implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event) {
			
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
		
		getCartes_adverses().add(new Button(partie.getJoueurQuiJouePas().getHeros().getNom()));
		getCartes_adverses().get(0).setDisable(true);
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_adverses().add(new Button());
			getCartes_adverses().get(i).setText(c.getNom() + "\n" + c.getClasse() + "\n" + c.getCout());
			getCartes_adverses().get(i).setDisable(true);
			i++;
		}
	}
	
	public void adversesButtonAttaque() {
		/**Construit un tableau de boutons activables représentant les serviteurs adverses présents sur le plateau
		 * et prêt à être attaqués*/
		
		int i = 1;
		
		for(Serviteur s : partie.getJoueurQuiJouePas().getPlateau().getServiteurs())
		{	
			getCartes_adverses().add(new Button(""));
			if(s.checkEffet("Provocation"))
				getCartes_adverses().get(i).setOnAction(new EvtEtreAttaque(null));
			i++;
		}
	}

	public void allieesButton() {
		/**Construit un tableau de bouton activables représentant les serviteurs alliés présent sur le plateau*/
		int i = 1;
		
		getCartes_alliees().add(new Button(partie.getJoueurQuiJoue().getHeros().getNom()));
		getCartes_alliees().get(0).setDisable(true);
		
		for(Serviteur c: partie.getJoueurQuiJoue().getPlateau().getServiteurs()) {
			getCartes_alliees().add(new Button());
			getCartes_alliees().get(i).setText(c.getNom() + "\n" + c.getEffet() + "\n Atk : "
					 +c.getAttaque()+ "Vie : "+c.getVie()+ "\n Cout : " +c.getCout()+ " mana");
			getCartes_alliees().get(i).setOnAction(new EvtAttaquer());
			
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
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJoue().getManaDispo()+" / "+partie.getJoueurQuiJoue().getManaMax() + "\t");
		
		HBox box = new HBox();
		
		box.getChildren().add(mana);
		
		for(Button c: getMain_alliee())
			box.getChildren().add(c);
		
		getRoot().getChildren().add(box);
	}
	
	public void buildCartesAdverses() {
		/**Place les serviteurs adverses et le héros dans un hbox placé en haut de la fenêtre*/
		
		HBox adverse = new HBox();
		
		for(Button c: getCartes_adverses())
			adverse.getChildren().add(c);
		
		getRoot().getChildren().add(adverse);
	}
	
	public void buildCartesAlliees() {
		/**Place les serviteurs alliés aux centre de la fenêtre*/
			
		HBox alliees = new HBox();
			
		for(Button c: getCartes_alliees())
			alliees.getChildren().add(c);
			
		getRoot().getChildren().add(alliees);	
	}
	
	private void buildMainAdverse() {
		
		Label mana = new Label("Mana : "+ partie.getJoueurQuiJouePas().getManaDispo()+" / "+partie.getJoueurQuiJouePas().getManaMax() + "\t");
		Label nbCartes = new Label("Votre adversaire a " + partie.getJoueurQuiJouePas().getMain().getCartes().size() + " cartes en main");
		
		HBox box = new HBox();
		
		box.getChildren().add(mana);
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
