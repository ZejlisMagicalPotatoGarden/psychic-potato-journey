package interfaceConsole;

import exceptions.InteractionException;
import partie.partie.Partie;

public abstract class Interface {
	/**
	 * Classe abstraite représentant une interface graphique, dès qu'un choix devra être fait on passera par une interface
	 * qui héritera de cette classe abstraite.
	 * 
	 *  @author GRESSET Nathan
	 *  @author GRINWALD Louis
	 *  
	 *  @see Interface
	 */

	private	Interface	suivant = null;
	
	public Interface(Interface ihm) {
		suivant = ihm;
	}
	
	public Interface getSuivant() {
		return suivant;
	}
	public void setSuivant(Interface suivant){
		this.suivant = suivant;
	}

	public abstract String getDescription();
	public abstract void	executerInteraction(Partie p) throws Exception;	
	
	
	public void interagir(String actionDemandees, Partie p) throws Exception {
		if (saisInteragir(actionDemandees))
			executerInteraction(p);
		else if (suivant != null)
			suivant.interagir(actionDemandees, p);
		else
			throw new InteractionException("Il n'existe aucune interaction pour "+actionDemandees);
	}
	public boolean saisInteragir(String actionDemandee){
		return actionDemandee.equals(this.getDescription());
	}


}