package partie.joueur.heros.mage;

import cartes.effets.Degats;
import partie.joueur.heros.pouvoir.Pouvoir;

public class Pouvoir_mage extends Pouvoir {
	/**
	 * Classe repr�sentant le pouvoir du mage, inflige un point de d�g�t � un personnage.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Mage
	 * @see Pouvoir
	 */

	public Pouvoir_mage() {
		super(new Degats("Fait un point de d�gat � un personnage", "Ping", "Imm�diat", 1),2);
	}

}
