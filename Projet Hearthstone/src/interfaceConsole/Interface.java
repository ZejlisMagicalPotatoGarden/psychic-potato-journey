package interfaceConsole;

import exceptions.InteractionException;
import partie.partie.Partie;

public abstract class Interface {

	private	Interface	suivant = null;
	
	public Interface(Interface ihm) {
		suivant = ihm;
	}
	
	public Interface getSuivant() {
		return suivant;
	}

	public abstract String getDescription();
	public abstract boolean	saisInteragir(String actionDemandee);
	public abstract void	executerInteraction(Partie p, boolean finDeTour) throws Exception;	
	
	
	public void interagir(String actionDemandees, Partie p, boolean finDeTour) throws Exception {
		if (saisInteragir(actionDemandees))
			executerInteraction(p, finDeTour);
		else if (suivant != null)
			suivant.interagir(actionDemandees, p, finDeTour);
		else
			throw new InteractionException("Il n'existe aucune interaction pour "+actionDemandees);
	}


}