package cartes.serviteurs;

import cartes.effets.Provocation;

public class L_ogre_magi extends Serviteur {
	/**
	 * Classe représentant le serviteur L'ogre magie, permet un effet de provocation.
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

	public L_ogre_magi() {
		super("L'ogre magi", 4, "Neutre", 4, 4, new Provocation());
	}

}
