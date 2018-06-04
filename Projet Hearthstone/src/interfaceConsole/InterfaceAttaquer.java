package interfaceConsole;

import java.util.ArrayList;

import cartes.serviteurs.Serviteur;
import console.Console;
import exceptions.HearthstoneException;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class InterfaceAttaquer extends Interface {
	/**
	 * Classe représentant l'interface d'attaque, permet de choisir d'attaquer. 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Interface
	 * 
	 * @param ihm interface
	 */

	public InterfaceAttaquer(Interface ihm) {
		super(ihm);
	}

	
	@Override
	public String getDescription() {
		return "Attaquer un adversaire avec un de vos serviteurs";
	}
	
	@Override
	public void executerInteraction(Partie p) throws Exception {
		Console es = new Console();
		
		Interface ihm = null;
		
		Joueur jQuiJoue = p.getJoueurQuiJoue();
		
		if(jQuiJoue.getPlateau().getServiteurs().isEmpty())
			throw new HearthstoneException("Vous n'avez pas de serviteurs");

		else
		{
			System.out.println("Avec quel serviteur ?");
			for(Serviteur s : jQuiJoue.getPlateau().getServiteurs())
			{
				if(s.isCapableAttaquer())
					ihm = new InterfaceChoixServiteurAllie(ihm, s);
			}
		}
		
		if(ihm == null)
			throw new HearthstoneException("Vous n'avez pas de serviteurs capables d'attaquer");
		
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
			e.getMessage();
		}
	}

}
