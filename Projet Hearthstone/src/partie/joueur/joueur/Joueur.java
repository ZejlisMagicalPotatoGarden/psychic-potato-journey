package partie.joueur.joueur;

import console.Console;
import partie.joueur.deck.Deck;
import partie.joueur.heros.heros.Heros;
import partie.joueur.main.Main;
import partie.joueur.plateau.Plateau;

public class Joueur {

	private Main main;
	private Deck deck;
	private Plateau plateau;
	private Heros heros;
	private int manaMax;
	private int manaDispo;
	
	public Joueur(Main main, Deck deck, Plateau plateau, Heros heros) {
		super();
		this.main = main;
		this.deck = deck;
		this.plateau = plateau;
		this.heros = heros;
		this.manaMax = 0;
		this.manaDispo = 0;
	}

	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	public Heros getHeros() {
		return heros;
	}
	public void setHeros(Heros heros) {
		this.heros = heros;
	}
	public int getManaMax() {
		return manaMax;
	}
	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}
	public int getManaDispo() {
		return manaDispo;
	}
	public void setManaDispo(int manaDispo) {
		this.manaDispo = manaDispo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		if (heros == null) {
			if (other.heros != null)
				return false;
		} else if (!heros.equals(other.heros))
			return false;
		if (main == null) {
			if (other.main != null)
				return false;
		} else if (!main.equals(other.main))
			return false;
		if (manaDispo != other.manaDispo)
			return false;
		if (manaMax != other.manaMax)
			return false;
		if (plateau == null) {
			if (other.plateau != null)
				return false;
		} else if (!plateau.equals(other.plateau))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Joueur [main=" + main + ", deck=" + deck + ", plateau=" + plateau + ", heros=" + heros + ", manaMax="
				+ manaMax + ", manaDispo=" + manaDispo + "]";
	}
	
	public String action(){
		String choix = "";
		Console es = new Console();
		do{
			es.println("Que voulez-vous faire ?");
			choix = es.readLine();
		}while(choix == null || !(choix.trim().equals("Attaquer") ||
				choix.trim().equals("Jouer") || choix.trim().equals("Passer")) );
		
		return choix;
	}
	public void piocher(int nbPioche){
		this.deck.piocher(nbPioche, this.main);
	}
	
}
