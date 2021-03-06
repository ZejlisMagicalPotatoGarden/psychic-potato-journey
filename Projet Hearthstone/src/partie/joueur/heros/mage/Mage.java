package partie.joueur.heros.mage;

import partie.joueur.heros.heros.Heros;

public class Mage extends Heros {
	/**
	 * Classe repr�sentant le mage, h�rite de H�ros, il poss�de des pouvoirs, des serviteurs et des sorts qui lui
	 * sont propres ainsi que les neutres.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Mage
	 */

	public Mage(){
		super("Jaina Portvaillant",new Pouvoir_mage());
	}
}
