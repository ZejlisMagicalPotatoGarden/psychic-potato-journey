package cartes.effets;

import partie.autres.personnage.Personnage;

public class Provocation extends Effet {
	/**
	 * Classe repr�sentant l'effet provocation, si un serviteur poss�de une provocation il sera obligatoirement 
	 * la cible prioritaire de l'adversaire.
	 * L'effet est port� par les serviteurs.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 *
	 */
	
	public Provocation() {
		super("Empeche les serviteurs d'attaquer le h�ros","Provocation","Provocation");
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
