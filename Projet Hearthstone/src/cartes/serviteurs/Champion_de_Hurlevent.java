package cartes.serviteurs;

import cartes.effets.Buff;

public class Champion_de_Hurlevent extends Serviteur {

	public Champion_de_Hurlevent() {
		super("Champion de hurlevent", 7, "Neutre", 6, 6, new Buff("Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1", "Bonus du hurlevent", "Aura", 1, 1));
	}

}
