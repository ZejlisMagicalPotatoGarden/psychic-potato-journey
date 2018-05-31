package partie.joueur.heros.chasseur;

import partie.joueur.heros.heros.Heros;
import partie.partie.Partie;

public class Chasseur extends Heros {
	/**
	 * Classe repr�sentant le chasseur, un chasseur est un h�ros, il poss�de des pouvoirs, des serviteurs et des effets
	 * qui lui sont propre ainsi que les neutres. 
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Heros
	 */

	public Chasseur(Partie p){
		super("Rexxar",15,new Pouvoir_chasseur(p));
	}
}

