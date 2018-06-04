package interfaceConsole;

import partie.partie.Partie;

public class InterfacePasserTour extends Interface {

	public InterfacePasserTour(Interface ihm) {
		super(ihm);
	}

	
	@Override
	public String getDescription() {
		return "Mettre fin à votre tour";
	}

	@Override
	public void executerInteraction(Partie p) throws Exception {
		p.setTourJ1(!p.isTourJ1());
	}

}
