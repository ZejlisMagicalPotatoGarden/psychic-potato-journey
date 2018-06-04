package cartes.serviteurs;

import cartes.effets.Buff_Aura;

public class Champion_de_Hurlevent extends Serviteur {
	/**
	 * Classe représentant le serviteur Champion de Hurlevent, permet un effet permanent sur tous les serviteurs
	 * de +1/+1, c'est un effet Buff.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * 
	 */

	public Champion_de_Hurlevent() {
		super("Champion de hurlevent", 7, "Neutre", 6, 6, new Buff_Aura("Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1", "Bonus du hurlevent", 1, 1));
	}

}
