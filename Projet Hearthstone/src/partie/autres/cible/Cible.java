package partie.autres.cible;

import java.util.ArrayList;

import cartes.serviteurs.Serviteur;
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
 * @deprecated
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
	
	
	public void prendreDegats(int x){
		for(Personnage p : getCibles()){
			p.prendreDegats(x);
		}
	}
	public void augmenterAttaque(int bonusAttaque) {
		for(Personnage p : getCibles()){
			p.augmenterAttaque(bonusAttaque);
		}
	}
	public void augmenterVie(int bonusVie) {
		for(Personnage p : getCibles()){
			p.augmenterVie(bonusVie);
		}
	}
	public int getAttaque() {
		int attaque = 0;
		Serviteur s = new Serviteur(null, 0, null, 0, 0, null);
		for(Personnage p : getCibles()){
			if(p.getClass() == s.getClass());
				attaque = attaque + ((Serviteur) p).getAttaque();
		}
		return attaque;
	}
	
}
