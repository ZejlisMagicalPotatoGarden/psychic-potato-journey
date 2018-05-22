package cartes.effets;

import partie.autres.personnage.Personnage;

public class E_Charge extends Effet {
	
	public E_Charge() {
		super("Permet au serviteur d'attaquer le premier tour","Charge","Charge");
	}
	
	@Override
	public void activer(Personnage p) {
		//Cet effet ne s'active jamais
	}
	@Override
	public boolean isActivable() {
		//cet effet ne s'active jamais
		return false;
	}
	@Override
	public boolean isCiblable(){
		return false;
	}
}
