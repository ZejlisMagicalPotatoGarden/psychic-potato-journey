package interfaceConsole;

import exceptions.HearthstoneException;
import partie.joueur.heros.pouvoir.Pouvoir;
import partie.partie.Partie;

public class InterfacePouvoirHeroique extends Interface {

	public InterfacePouvoirHeroique(Interface ihm) {
		super(ihm);
	}
	
	@Override
	public String getDescription() {
		return "Utiliser votre pouvoir héroique";
	}

	@Override
	public void executerInteraction(Partie p) throws Exception {
		Pouvoir pouvoir = p.getJoueurQuiJoue().getHeros().getPouvoir();
		
		if(p.getJoueurQuiJoue().getManaDispo() < p.getJoueurQuiJoue().getHeros().getPouvoir().getCout())
			throw new HearthstoneException("Vous n'avez pas assez de mana");
		
		if(!p.getJoueurQuiJoue().getHeros().getPouvoir().isActivable())
			throw new HearthstoneException("Ce pouvoir a déjà été utilisé");
		
		if(pouvoir.getEffet().isCiblable()){
			Interface ihm = new InterfaceCiblage(null, pouvoir.getEffet());
			ihm.interagir("Choisir un personnage à cibler pour "+pouvoir, p);
		}
		else
			pouvoir.activer(null);
		
		p.getJoueurQuiJoue().setManaDispo(p.getJoueurQuiJoue().getManaDispo() - p.getJoueurQuiJoue().getHeros().getPouvoir().getCout());
		p.checkMorts();
	}
}
