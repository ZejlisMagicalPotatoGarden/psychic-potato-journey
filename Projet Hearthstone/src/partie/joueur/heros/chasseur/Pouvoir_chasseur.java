package partie.joueur.heros.chasseur;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_chasseur extends Pouvoir {
	/**
	 * Classe repr�sentant le pouvoir sp�cifique au chasseur, fait 2 points de d�g�ts au h�ros adverse.
	 * 
	 * @author GRESSET Nathan
	 * @author GRIWALD Louis
	 * 
	 * @see Pouvoir
	 */

	public Pouvoir_chasseur() {
		super(new Degats("Fait 2 points de d�gats au h�ros adverse", "Tir pr�cis", "Imm�diat", 2), 2);
	}

}
