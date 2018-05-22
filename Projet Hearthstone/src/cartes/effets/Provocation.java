package cartes.effets;

import partie.autres.personnage.Personnage;

public class Provocation extends Effet {
	
	public Provocation() {
		super("Empeche les serviteurs d'attaquer le héros","Provocation","Provocation");
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
