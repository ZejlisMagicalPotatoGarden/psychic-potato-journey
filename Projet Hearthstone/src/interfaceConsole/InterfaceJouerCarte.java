package interfaceConsole;

import java.util.ArrayList;

import console.Console;
import exceptions.HearthstoneException;
import partie.joueur.joueur.Joueur;
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
	public void executerInteraction(Partie p) throws Exception {
		Console es = new Console();
		
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		
		Interface ihm = null;
		
		if(jQuiJoue.getMain().getCartes().isEmpty())
			throw new HearthstoneException("Vous n'avez pas de carte pour faire cela");
	
		
		for(int i=1; i<=jQuiJoue.getMain().getCartes().size(); i++)
		{
			ihm = new InterfaceChoixCarteAJouer(ihm, jQuiJoue.getMain().getCartes().get(i - 1));
		}
		
		ArrayList<String>	menu = new ArrayList<String>();
		Interface i = ihm;
		while (i != null) {
			menu.add(i.getDescription());
			i = i.getSuivant();
		}
		
		int n = 1;
		for (String s : menu) {
			es.println(""+n+". "+s);
			n++;
		}
		
		es.println("");
		es.println("Votre choix : ");
		int choix = es.readInt();
		String choixEnChaine = menu.get(choix-1);
		
		try {
			ihm.interagir(choixEnChaine, p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
