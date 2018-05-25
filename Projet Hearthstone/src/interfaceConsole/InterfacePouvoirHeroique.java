package interfaceConsole;

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
		
		//Exception
		if(p.getJoueurQuiJoue().getManaDispo() < p.getJoueurQuiJoue().getHeros().getPouvoir().getCout())
			System.out.println("Vous n'avez pas assez de mana");
		if(!p.getJoueurQuiJoue().getHeros().getPouvoir().isActivable())
			System.out.println("Pouvoir déja utilisé");
		
		if(pouvoir.getEffet().isCiblable()){
			if(pouvoir.getEffet().isActivable())
			{
				Interface ihm = new InterfaceCiblage(null, pouvoir.getEffet());
				ihm.interagir("Choisir un personnage à cibler pour "+pouvoir.getEffet(), p);
			}
		}
		else
			pouvoir.getEffet().activer(null);
		p.getJoueurQuiJoue().setManaDispo(p.getJoueurQuiJoue().getManaDispo() - p.getJoueurQuiJoue().getHeros().getPouvoir().getCout());
		p.checkMorts();
	}
}
