package cartes.effets;

import cartes.serviteurs.Serviteur;
import partie.autres.personnage.Personnage;

public class E_Charge extends Effet {
	
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
