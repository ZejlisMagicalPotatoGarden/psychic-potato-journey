package interfaceConsole;

import java.util.ArrayList;

import cartes.effets.Effet;
import cartes.serviteurs.Serviteur;
import console.Console;
import partie.partie.Partie;

public class InterfaceCiblage extends Interface {

	private Effet effet;
	
	public InterfaceCiblage(Interface ihm, Effet effet) {
		super(ihm);
		this.effet = effet;
	}

	@Override
	public String getDescription() {
		return "Choisir un personnage à cibler pour "+effet;
	}

	@Override
	public void executerInteraction(Partie p) throws Exception {
		Console es = new Console();
		
		Interface ihm = null;
		
		if(!p.getJoueur1().getPlateau().getServiteurs().isEmpty())
		{
			for(Serviteur s : p.getJoueur1().getPlateau().getServiteurs())
			{
				ihm = new InterfaceChoixCible(ihm, s, effet);
			}
		}
		if(!p.getJoueur2().getPlateau().getServiteurs().isEmpty())
		{
			for(Serviteur s : p.getJoueur2().getPlateau().getServiteurs())
			{
				ihm = new InterfaceChoixCible(ihm, s, effet);
			}
		}
		ihm = new InterfaceChoixCible(ihm, p.getJoueur1().getHeros(), effet);
		ihm = new InterfaceChoixCible(ihm, p.getJoueur2().getHeros(), effet);
		
		
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
