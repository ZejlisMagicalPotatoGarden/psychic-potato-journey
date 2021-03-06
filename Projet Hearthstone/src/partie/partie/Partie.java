package partie.partie;

import java.util.ArrayList;

import application.App;
import interfaceGraphique.FenetrePrincipale;
import cartes.serviteurs.Serviteur;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import partie.joueur.joueur.Joueur;

public class Partie {
	/**
	 * Classe repr�sentant une partie, elle est compos�e de deux joueurs qui s'affrontent,
	 * ainsi qu'un bool�en permettant de savoir qui � la main.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 */

	private Joueur joueur1;
	private Joueur joueur2;
	private boolean tourJ1; 
	
	public Partie(Joueur joueur1, Joueur joueur2) {
		setJoueur1(joueur1);
		setJoueur2(joueur2);
		setTourJ1(true);
	}
	
	public Joueur getJoueur1() {
		return joueur1;
	}
	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	public Joueur getJoueur2() {
		return joueur2;
	}
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
	public boolean isTourJ1() {
		return tourJ1;
	}
	public void setTourJ1(boolean tourJ1) {
		this.tourJ1 = tourJ1;
	}

	
	@Override
	public String toString() {
		return "Partie [joueur1=" + joueur1 + ", joueur2=" + joueur2 + ", tourJ1=" + tourJ1 + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		if (joueur1 == null) {
			if (other.joueur1 != null)
				return false;
		} else if (!joueur1.equals(other.joueur1))
			return false;
		if (joueur2 == null) {
			if (other.joueur2 != null)
				return false;
		} else if (!joueur2.equals(other.joueur2))
			return false;
		if (tourJ1 != other.tourJ1)
			return false;
		return true;
	}

	
	public static void Gagner(Joueur gagnant){
		if(!App.IS_GRAPHIQUE)
			System.out.printf("%s (%s) a gagn�\n",gagnant,gagnant.getHeros().getNom());
		else
		{
			VBox root = new VBox();
			root.setPadding(new Insets(5,5,5,5));
			root.setSpacing(5);
			
			Scene scene = new Scene(root, 400, 200);	
			FenetrePrincipale f = App.f;
			Stage s = new Stage();
			s.setTitle("Fin de la partie");
			s.initModality(Modality.WINDOW_MODAL);
			s.initOwner(f.getStage());
			
			s.setScene(scene);
			
			Label gagnanttexte = new Label(gagnant.getHeros().getNom() + " a gagn�");
			root.getChildren().add(gagnanttexte);
			
			s.show();
		}
			
		System.exit(0);
	}
	public Joueur getJoueurQuiJoue(){
		if(this.tourJ1)
			return this.joueur1;
		else
			return this.joueur2;
	}
	public Joueur getJoueurQuiJouePas(){
		if(this.tourJ1)
			return this.joueur2;
		else
			return this.joueur1;
	}
	
	public void checkMorts() throws Exception{
		if(joueur1.getHeros().isMort())
			joueur1.getHeros().mourir(joueur2);
		if(joueur2.getHeros().isMort())
			joueur2.getHeros().mourir(joueur1);
		
		ArrayList<Serviteur> morts = new ArrayList<Serviteur>();
		for (Serviteur s : joueur1.getPlateau().getServiteurs()) {
			if(s.isMort())
				morts.add(s);
		}
		for(Serviteur s : morts)
			s.mourir(joueur1);
		
		morts = new ArrayList<Serviteur>();
		for (Serviteur s : joueur2.getPlateau().getServiteurs()) {
			if(s.isMort())
				morts.add(s);
		}
		for(Serviteur s : morts)
			s.mourir(joueur2);
	}
}
