package partie.autres.cible;

import java.util.ArrayList;

import cartes.serviteur.Serviteur;
import partie.autres.personnage.Personnage;
import partie.joueur.joueur.Joueur;
import partie.joueur.plateau.Plateau;
import partie.partie.Partie;

public class Cible {
/**
 * Classe représentant une cible pour un effet, une cible est un tableau de personnages
 * On peut faire à une cible tout ce qu'on peut faire à un personnage(lui faire des dégats
 * le tuer ---------------A COMPLETER-------------)
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Effet
 * @see Personnage
 * @see Plateau
 */
 
	private ArrayList<Personnage> cibles;
	
	public Cible(Plateau p){
		cibles = new ArrayList<Personnage>();
		for(Serviteur perso : p.getServiteurs()){
			cibles.add(perso);
		}
	}
	public Cible(ArrayList<Personnage> p){
		cibles = new ArrayList<Personnage>();
		cibles = p;
	}
	public Cible(Personnage p){
		cibles = new ArrayList<Personnage>();
		cibles.add(p);
	}
	public Cible(Joueur j){
		cibles = new ArrayList<Personnage>();
		for(Serviteur perso : j.getPlateau().getServiteurs()){
			cibles.add(perso);
		}
		cibles.add(j.getHeros());
	}
	public Cible(Partie p){
		cibles = new ArrayList<Personnage>();
		for(Personnage perso : p.getJoueur1().getPlateau().getServiteurs()){
			cibles.add(perso);
		}
		for(Personnage perso : p.getJoueur2().getPlateau().getServiteurs()){
			cibles.add(perso);
		}
		cibles.add(p.getJoueur1().getHeros());
		cibles.add(p.getJoueur2().getHeros());
	}
	
	public ArrayList<Personnage> getCibles() {
		return cibles;
	}
	public void setCibles(ArrayList<Personnage> cibles) {
		this.cibles = cibles;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cible other = (Cible) obj;
		if (cibles == null) {
			if (other.cibles != null)
				return false;
		} else if (!cibles.equals(other.cibles))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cible [cibles=" + cibles + "]";
	}
	
	
	
}
