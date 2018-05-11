package cartes.effets;

import partie.autres.cible.Cible;

public class E_Charge extends Effet {
	
	public E_Charge() {
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
