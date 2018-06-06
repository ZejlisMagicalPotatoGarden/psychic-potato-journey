package cartes.effets;

import cartes.serviteurs.Serviteur;
import partie.autres.personnage.Personnage;

public class E_Charge extends Effet {
	/**
	 * Classe représentant l'effet charge, il permet à un serviteur d'attaquer le tour ou il a été invoqué
	 * Hérite de Effet
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 */
	
	public E_Charge() {
		super("Permet au serviteur d'attaquer le premier tour","Charge","Charge");
	}
	
	@Override
	public void activer(Personnage p) {
		((Serviteur) p).setNbAttaques(1);
	}
	@Override
	public boolean isActivable() {
		return true;
	}
	@Override
	public boolean isCiblable(){
		return true;
	}
}
