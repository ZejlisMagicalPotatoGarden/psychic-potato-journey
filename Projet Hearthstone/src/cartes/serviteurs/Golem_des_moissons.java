package cartes.serviteurs;

import cartes.effets.Invocation;
import partie.partie.Partie;

public class Golem_des_moissons extends Serviteur {
	/**
	 * Classe repr�sentant le Golem des moissons, permet d'invoquer un golem endommag� +2/+1 sans capacit�
	 * � sa mort
	 * C'est un effet d'invocation.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Serviteur
	 * 
	 */

	public Golem_des_moissons(Partie partie) {
		super("Golem des moissons", 3, "Neutre", 3, 2, new Invocation("Invoque un Golem endomag� 2/1", "Gol�misation", "Mort", new Serviteur("Golem endomag�", 0, "Neutre", 1, 2, null), 1, partie));
	}

}
