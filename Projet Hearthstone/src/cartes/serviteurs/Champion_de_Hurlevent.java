package cartes.serviteurs;

import cartes.effets.Buff;

public class Champion_de_Hurlevent extends Serviteur {
	/**
	 * Classe représentant le serviteur Champion de Hurlevent, permet un effet permanent sur tous les serviteurs
	 * de +1/+1, c'est un effet Buff.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see serviteurs
	 * @see effets
	 * @see carte
	 * 
	 * @param nom
	 * @param cout
	 * @param classe
	 * @param vieMax
	 * @param attaque
	 * @param effet
	 */

	public Champion_de_Hurlevent() {
		super("Champion de hurlevent", 7, "Neutre", 6, 6, new Buff("Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1", "Bonus du hurlevent", "Aura", 1, 1));
	}

}
