package interfaceConsole;

import cartes.effets.Effet;
import partie.autres.personnage.Personnage;
import partie.partie.Partie;

public class InterfaceChoixCible extends Interface {
	/**
	 * Classe représentant le choix d'un personnage à cibler, elle est composée d'un effet
	 * et d'une cible.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Interface
	 */
	
	private Effet effet;
	private Personnage cible;
	
	public InterfaceChoixCible(Interface ihm, Personnage cible, Effet effet) {
		super(ihm);
		this.effet = effet;
		this.cible = cible;
	}

	@Override
	public String getDescription() {
		return "Cibler "+cible+" pour "+effet;
	}

	@Override
	public void executerInteraction(Partie p){
		effet.activer(cible);
	}
}
