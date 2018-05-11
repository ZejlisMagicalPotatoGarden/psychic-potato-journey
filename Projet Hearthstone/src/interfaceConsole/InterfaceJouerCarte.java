package interfaceConsole;

import partie.partie.Partie;

public class InterfaceJouerCarte extends Interface {

	public InterfaceJouerCarte(Interface ihm) {
		super(ihm);
	}

	
	@Override
	public String getDescription() {
		return "Jouer une carte de votre main";
	}

	@Override
	public boolean saisInteragir(String actionDemandee) {
		return actionDemandee.equals("Jouer une carte de votre main");
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
