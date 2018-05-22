package cartes.effets;

import partie.autres.cible.Cible;

public class Provocation extends Effet {
	/**
	 * Classe représentant l'effet provocation, si un serviteur possède une provocation il sera obligatoirement 
	 * la cible prioritaire de l'adversaire.
	 * L'effet est porté par les serviteurs.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 * @see serviteurs
	 *
	 * 
	 */
	
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
