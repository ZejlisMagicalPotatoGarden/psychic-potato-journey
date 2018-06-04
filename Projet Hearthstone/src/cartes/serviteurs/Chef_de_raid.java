package cartes.serviteurs;

import cartes.effets.Buff_Aura;

public class Chef_de_raid extends Serviteur {
	/**
	 * Classe représentant le serviteur Chef de raid, permet un effet permanent sur les autres serviteurs de +1/0.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis 
	 * 
	 * @see Serviteur
	 * 
	 */

	public Chef_de_raid() {
		super("Chef de raid", 3,"Neutre", 2, 2, new Buff_Aura("Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1","Bonus du chef de raid", "Aura", 1,1));
	}

}
