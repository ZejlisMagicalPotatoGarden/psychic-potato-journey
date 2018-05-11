package cartes.effets;

import partie.autres.cible.Cible;

public class Provocation extends Effet { 
	
	public Provocation() {
		super("Empeche les serviteurs d'attaquer le héros","Provocation","Provocation");
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
