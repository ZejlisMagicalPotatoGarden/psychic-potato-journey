package interfaceConsole;

import cartes.carte.Carte;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class InterfaceChoixCarteAJouer extends Interface {
	/**
	 * Classe représentant le choix d'une carte à jouer.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Interface
	 */

	private Carte carte;

	public InterfaceChoixCarteAJouer(Interface ihm, Carte carte) {
		super(ihm);
		setCarte(carte);
	}

	
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}


	@Override
	public String getDescription() {
		return "Jouer "+ carte;
	}

	@Override
	public void executerInteraction(Partie p) throws Exception{
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		
		//exception
		if(p.getJoueurQuiJoue().getManaDispo() < carte.getCout())
			System.out.println("Vous n'avez pas assez de mana");
		
		if(carte.checkEffet("Entrée") || carte.checkEffet("Immédiat")){
			if(carte.getEffet().isCiblable()){
				if(carte.getEffet().isActivable()){
					Interface ihm = new InterfaceCiblage(null, carte.getEffet());
					try{
						ihm.interagir("Choisir un personnage à cibler pour "+carte.getEffet(), p);
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			else
				carte.getEffet().activer(null);
		}
		jQuiJoue.getMain().jouerCarte(carte.getNom(), jQuiJoue.getPlateau());
		jQuiJoue.setManaDispo(jQuiJoue.getManaDispo() - carte.getCout());
	}

}
