package interfaceConsole;

import partie.partie.Partie;

public class InterfaceAttaquer extends Interface {

	public InterfaceAttaquer(Interface ihm) {
		super(ihm);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String getDescription() {
		return "Attaquer un adversaire avec un de vos serviteurs";
	}

	@Override
	public boolean saisInteragir(String actionDemandee) {
		return actionDemandee.equals("Attaquer un adversaire avec un de vos serviteurs");
	}

	@Override
	public void executerInteraction(Partie p, boolean finDeTour) throws Exception {
		// TODO Auto-generated method stub

	}

}
