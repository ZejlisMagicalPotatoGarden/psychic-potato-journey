package cartes.sorts;

import cartes.effets.Degats;

public class Explosion_pyrotechnique extends Sort {

	public Explosion_pyrotechnique() {
		super("Explosion pyrotechnique", 10, new Degats("Inflige 10 points de d�g�ts au personnage cibl�", "Explosion pyrotechnique", "Imm�diat", 10), "Mage");
	}

}
