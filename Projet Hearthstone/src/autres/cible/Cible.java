package cible;

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
		cibles = p.getServiteurs();
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
		cibles = j.getPlateau().getPersonnages();
		cibles.add(j.getHeros());
	}
	public Cible(Partie p){
		cibles = new ArrayList<Personnage>();
		for(Personnage perso : p.getJoueur1().getPlateau().getPersonnages()){
			cibles.add(perso);
		}
		for(perso : p.getJoueur2().getPlateau().getPersonnages()){
			cibles.add(perso);
		}
		cibles.add(p.getJoueur1().getHeros());
		cibles.add(p.getJoueur2().getHeros());
	}
	
	//------------------Rajouter tout le bordel--------------------
}
