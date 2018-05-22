package cartes.serviteurs;

import cartes.effets.Buff;

public class Chef_de_raid extends Serviteur {

	public Chef_de_raid() {
		super("Chef de raid", 3,"Neutre", 2, 2, new Buff("Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1","Bonus du chef de raid", "Aura", 1,1));
	}

}
