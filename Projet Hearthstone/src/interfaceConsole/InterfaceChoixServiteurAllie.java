package interfaceConsole;

import java.util.ArrayList;

import cartes.serviteurs.Serviteur;
import console.Console;
import partie.joueur.joueur.Joueur;
import partie.partie.Partie;

public class InterfaceChoixServiteurAllie extends Interface {
	/**
	 * Classe représentant le choix du serviteur qui va attaquer, elle a besoin d'un serviteur.
	 */

	private Serviteur serviteur;
	
	public InterfaceChoixServiteurAllie(Interface ihm, Serviteur serviteur) {
		super(ihm);
		setServiteur(serviteur);
	}

	
	public Serviteur getServiteur() {
		return serviteur;
	}
	public void setServiteur(Serviteur serviteur) {
		this.serviteur = serviteur;
	}


	@Override
	public String getDescription() {
		return "Attaquer avec "+ serviteur;
	}

	@Override
	public void executerInteraction(Partie p) throws Exception {
		Joueur jEnnemi = p.getJoueurQuiJouePas();
		
		Console es = new Console();
		
		Interface ihm = null;
		
		if(jEnnemi.getPlateau().getProvocs().isEmpty())
		{
			System.out.println("Quel adversaire ?");
			for(Serviteur s : jEnnemi.getPlateau().getServiteurs())
			{
				ihm = new InterfaceChoixEnnemiAttaque(ihm, s, serviteur);
			}
			ihm = new InterfaceChoixEnnemiAttaque(ihm,jEnnemi.getHeros(), serviteur);
		}
		else
		{
			System.out.println("Vous devez attaquer un de ces serviteurs avec provocation");
			for(Serviteur s : jEnnemi.getPlateau().getProvocs())
			{
				ihm = new InterfaceChoixEnnemiAttaque(ihm, s, serviteur);
			}
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
