package partie.joueur.heros.chasseur;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_chasseur extends Pouvoir {

	public Pouvoir_chasseur() {
		super(new Degats("Fait 2 poinrts de d�gats au h�ros adverse", "Tir pr�cis", "Imm�diat", 2), 2);
	}

}
