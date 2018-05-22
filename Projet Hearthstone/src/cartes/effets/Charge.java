package cartes.effets;

import partie.autres.cible.Cible;

public class Charge extends Effet {
	/**
	 * Classe représentant l'effet charge qui permet au serviteur d'attaquer au premier tour,
	 * elle ne possède aucun champ
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 */
	
	public Charge() {
		super("Permet au serviteur d'attaquer le premier tour","Charge","Charge");
	}
	
	@Override
	public void activer(Cible c) {
		//Cet effet ne s'active jamais
	}
	@Override
	public boolean isActivable(Cible c) {
		//cet effet ne s'active jamais
		return false;
	}
	@Override
	public boolean isCiblable(){
		return false;
	}
}
